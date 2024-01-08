import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테케 수
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            // 스티커의 열 수
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N + 1];
            int[][] dp = new int[2][N + 1];

            // 스티커 점수 입력
            for (int i = 0; i < 2; i++) {
                String[] tokens = br.readLine().split(" "); // 공백을 구분자로 사용하여 문자열을 분할

                for (int j = 1; j <= N; j++) {
                    sticker[i][j] = Integer.parseInt(tokens[j - 1]); // 배열 인덱스 조정
                }
            }

            // 구현
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];
            for(int i = 2; i <= N; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}