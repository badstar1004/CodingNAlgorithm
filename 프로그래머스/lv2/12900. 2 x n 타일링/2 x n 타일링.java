class Solution {
    public int solution(int n) {
        int answer = 0;
        final int MOD = 1_000_000_007;
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        
        return dp[n];
    }
}