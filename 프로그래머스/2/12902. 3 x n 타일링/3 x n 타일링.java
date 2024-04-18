class Solution {
    
    static final int MOD = 1_000_000_007;
    
    public int solution(int n) {
         if (n == 2) {
            return 3;
        }
        if (n == 4) {
            return 11;
        }

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 3;
        dp[4] = 11;

        for (int i = 6; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for(int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }

            dp[i] %= MOD;
        }

        return (int) dp[n];
    }
}