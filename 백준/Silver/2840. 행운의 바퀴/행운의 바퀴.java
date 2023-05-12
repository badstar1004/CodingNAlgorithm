import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');
        int curIdx = 0;

        while (K-- > 0) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int step = Integer.parseInt(st2.nextToken());
            char nextAlphabet = st2.nextToken().charAt(0);

            // 몇바퀴를 돌았을지, 음수를 리턴할수 있어 N 을 더하고 다시 % 해준다
            int nextIdx = ((curIdx - step) % N + N) % N;

            if(wheel[nextIdx] == '?') {
                wheel[nextIdx] = nextAlphabet;

            } else if (wheel[nextIdx] != nextAlphabet) {
                System.out.println("!");
                return;
            }

            curIdx = nextIdx;
        }

        boolean[] isExist = new boolean[26];
        for (int i = 0; i < N; i++) {

            // 물음표인지 아닌지
            if(wheel[i] == '?'){
                continue;
            }

            if (isExist[wheel[i] - 'A']) {
                System.out.println("!");
                return;
            }

            isExist[wheel[i] - 'A'] = true;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(wheel[(curIdx + i) % N]);
        }
        System.out.println();

    }
}