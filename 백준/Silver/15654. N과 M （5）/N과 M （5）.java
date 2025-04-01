import java.util.*;
import java.io.*;

public class Main {
    
    // N, M
    static int N, M;
    // 방문 여부 배열
    static boolean[] visited;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        visited = new boolean[N];
        result = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 사전 순 출력을 위한 정렬
        Arrays.sort(arr);  
        dfs(0);
        System.out.print(sb);
    }
    
    
    // dfs
    static void dfs(int depth) {
        // 탈출 조건
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
    
}