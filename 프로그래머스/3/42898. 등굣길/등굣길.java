class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        int MOD = 1_000_000_007;
        
        /*
            웅덩이 위치 -1로 초기화 후
            0 으로 초기화
        */
        for(int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        // 시작 위치
        dp[0][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // 웅덩이 continue;
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                
                // 위쪽에서 오는 경우의 수
                if(i > 0) {
                    dp[i][j] += dp[i - 1][j];
                    dp[i][j] %= MOD;
                }
                
                // 왼쪽에서 오는 경우의 수
                if(j > 0) {
                    dp[i][j] += dp[i][j - 1];
                    dp[i][j] %= MOD;
                }
            }
        }
        
        return dp[n - 1][m - 1];
    }
}