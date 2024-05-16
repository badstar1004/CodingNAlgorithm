import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 닭의 수
        int C = Integer.parseInt(st.nextToken());

        // 소의 수
        int N = Integer.parseInt(st.nextToken());

        // 닭이 도와줄 수 있는 초
        int[] helpChickenTimes = new int[C];
        for(int i = 0; i < C; i++) {
            helpChickenTimes[i] = Integer.parseInt(br.readLine());
        }

        // 소가 건널 수 있는 초 (시작, 끝)
        int[][] cows = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        // 닭 시간 오름차순 정렬
        Arrays.sort(helpChickenTimes);

        // 소의 오름차순 정렬
        Arrays.sort(cows, Comparator.comparingInt(a -> a[1]));

        boolean[] usedChicken = new boolean[C];
        int count = 0;

        for(int[] cow : cows) {
            for(int j = 0; j < C; j++) {
                if(!usedChicken[j] && helpChickenTimes[j] >= cow[0] && helpChickenTimes[j] <= cow[1]) {
                    usedChicken[j] = true;
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}