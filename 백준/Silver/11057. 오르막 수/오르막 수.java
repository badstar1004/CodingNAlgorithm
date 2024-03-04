import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 길이가 N, 0 ~ 9까지
        int[][] dp = new int[N + 1][10];

        // N = 1 일 때
        for(int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // dp
        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k] % MOD;
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < 10; i++) {
            sum += dp[N][i];
            sum %= MOD;
        }
        System.out.println(sum);
    }
}