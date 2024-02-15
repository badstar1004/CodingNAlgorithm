import java.io.*;

public class Main {
    
    private static int MOD = 10_007; 
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 2];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        for(int i = 3; i <= N; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) + dp[i - 2]) % MOD;
        }
        
        System.out.println(dp[N]);
    }
}