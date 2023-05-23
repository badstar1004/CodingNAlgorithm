import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        Integer[][] time = new Integer[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 0: 시작시간, 1: 종료시간
            time[i][0] = Integer.valueOf(st.nextToken());
            time[i][1] = Integer.valueOf(st.nextToken());
        }

        // 정렬
        Arrays.sort(time, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        // 비교
        int cnt = 0;
        int endTime = 0;
        for (Integer[] item : time) {
            if(endTime <= item[0]) {
                cnt++;
                endTime = item[1];
            }
        }

        System.out.println(cnt);
    }
}