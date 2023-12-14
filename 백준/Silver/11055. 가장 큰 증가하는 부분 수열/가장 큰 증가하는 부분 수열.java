import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 크기
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        
        // A
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // dp
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            // 최소 합 = 자기 자신
            dp[i] = A[i]; 
            
            for(int j = 0; j < i; j++) {
                if(A[j] < A[i] && dp[i] < dp[j] + A[i]) {
                    dp[i] = dp[j] + A[i];
                }
            }
        }
        
        
        // 최대 합 찾기
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        // 출력
        System.out.println(max);
        br.close();
    }
}