import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            // 동전의 종류 수
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int n = 0; n < N; n++) {
                coins[n] = Integer.parseInt(st.nextToken());
            }

            // 목표 금액
            int goalPrice = Integer.parseInt(br.readLine());

            // dp
            System.out.println(CoinChangeWays(coins, goalPrice));
        }
    }

    // dp
    private static int CoinChangeWays(int[] coins, int goalPrice) {
        int[] dp = new int[goalPrice + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= goalPrice; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[goalPrice];
    }
}