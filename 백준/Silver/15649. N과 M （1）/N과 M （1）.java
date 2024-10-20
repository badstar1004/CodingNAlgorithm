import java.util.*;
import java.io.*;

public class Main {
    
    // N, M
    public static int N, M;
    // 방문 여부 배열
    public static boolean[] visited;
    public static int[] result;
    public static StringBuilder sb = new StringBuilder();
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N];
        result = new int[M];
        
        dfs(0);
        System.out.println(sb);
    }
    
    
    // dfs
    public static void dfs(int depth) {
        // 탈출 조건
        if(depth == M) {
            for(Integer n : result) {
                sb.append(n).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;    // 다시 되돌리기
            }
        }
    }
    
}