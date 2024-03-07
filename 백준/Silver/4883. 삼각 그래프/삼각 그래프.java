import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 결과값
        StringBuilder sb = new StringBuilder();

        int T = 1;

        while (true) {
            // 삼각형 높이
            int N = Integer.parseInt(br.readLine());

            // 마지막 0 일 경우 종료
            if (N == 0) {
                break;
            }

            // map 기준 데이터 삽입
            int[][] map = new int[N + 1][3];
            for (int i = 1; i <= N; i++) {
                String[] line = br.readLine().split(" ");

                for (int j = 0; j < 3; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }

            // dp 초기화
            int[][] dp = new int[N + 1][3];
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = 1_000_001;       //비용의 제곱은 1,000,000보다 작다.
                }
            }

            // 두번째 줄까지 dp 초기화
            dp[1][1] = map[1][1];       // 첫번째 가운데
            dp[1][2] = dp[1][1] + map[1][2];        // 첫번째 오른쪽

            dp[2][0] = dp[1][1] + map[2][0];        // 두번째 왼쪽

            // 두번째 가운데
            dp[2][1] = Math.min(dp[2][1],       // dp 초기화 값
                    Math.min(dp[1][1] + map[2][1],      // 첫째줄 가운데 값
                            Math.min(dp[1][2] + map[2][1], dp[2][0] + map[2][1])));     // 첫번째 오른쪽 | 두번째 왼쪽

            // 두번째 오른쪽
            dp[2][2] = Math.min(dp[2][2],       // dp 초기화 값
                    Math.min(dp[1][1] + map[2][2],      // 첫째줄 가운데 값
                            Math.min(dp[2][1] + map[2][2], dp[1][2] + map[2][2])));     // 두번째 가운데 | 첫번째 오른쪽


            for (int i = 3; i <= N; i++) {
                // 왼쪽
                dp[i][0] = Math.min(dp[i][0],       // dp 초기화 값
                        Math.min(dp[i - 1][0] + map[i][0], dp[i - 1][1] + map[i][0]));      // 이전줄 왼쪽 | 이전줄 가운데

                // 가운데
                dp[i][1] = Math.min(dp[i][1],       // dp 초기화 값
                        Math.min(dp[i - 1][0] + map[i][1],      // 이전줄 왼쪽
                                Math.min(dp[i - 1][1] + map[i][1],      // 이전줄 가운데
                                        Math.min(dp[i][0] + map[i][1], dp[i - 1][2] + map[i][1]))));     // 현재줄 왼쪽 | 이전줄 오른쪽

                // 오른쪽
                dp[i][2] = Math.min(dp[i][2],       // dp 초기화 값
                        Math.min(dp[i - 1][1] + map[i][2],      // 이전줄 가운데
                                Math.min(dp[i][1] + map[i][2], dp[i - 1][2] + map[i][2])));     // 현재줄 가운데 | 이전줄 오른쪽
            }

            sb.append(T)
                    .append(". ")
                    .append(dp[N][1])
                    .append("\n");

            T++;
        }

        System.out.println(sb);

    }
}