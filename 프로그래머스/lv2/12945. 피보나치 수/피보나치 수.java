class Solution {
    public int solution(int n) {
        int answer = 0;
        // DP
        int[] dp = new int[n + 1];
        dp[0] = 0;
    	dp[1] = 1;
        
        // n = 0
        if(n == 0){
            return dp[0];
            // n = 1
        } else if(n == 1) {
            return dp[1];
            
        } else {
            for(int i = 2; i < n + 1; i++){
                dp[i] = (dp[i - 1] % 1234567) + (dp[i - 2] % 1234567);
            }
        }
        
        return (dp[n] % 1234567);
    }
}