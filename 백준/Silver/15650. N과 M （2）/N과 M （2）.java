import java.util.*;
import java.io.*;

public class Main {
    
    public static int N, M;
    public static int[] arr;
    public static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N + 1];
        
        backtrack(0);
    }
    
    public static void backtrack(int depth) {
        // 탈출 조건
        if(depth == M) {
            StringBuilder sb = new StringBuilder();
            for(int n : arr) {
                sb.append(n).append(" ");
            }
            System.out.println(sb);
            return;
        }
        
        // 백트래킹
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                if(depth == 0 || arr[depth - 1] < i) {
                    visited[i] = true;
                    arr[depth] = i;
                    backtrack(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}