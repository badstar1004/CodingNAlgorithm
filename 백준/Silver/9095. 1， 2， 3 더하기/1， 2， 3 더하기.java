import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 개수
        int T = Integer.parseInt(br.readLine());
        
        int[] dp = new int[11];
        dp[0] = 1; dp[1] = 1; dp[2] = 2;
        
        for(int i = 3; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.println(sb.toString());
    }
}