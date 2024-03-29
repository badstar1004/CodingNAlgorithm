import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] T = new int[N + 1];    // 걸리는 일수
        int[] P = new int[N + 1];    // 상담 페이
        int[] dp = new int[N + 2];
        
        // 데이터 삽입
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        // dp
        for(int i = N; i > 0; i--) {
            if(T[i] + i <= N + 1) {
                dp[i] = Math.max(P[i] + dp[i + T[i]], dp[i + 1]);
                
            } else {
                dp[i] = dp[i + 1];
            }
        }
        
        System.out.println(dp[1]);
    }
}