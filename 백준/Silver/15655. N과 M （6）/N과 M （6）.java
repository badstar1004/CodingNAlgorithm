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
        dfs(0, 0);
        System.out.print(sb);
    }
    
    
    // dfs
    static void dfs(int depth, int start) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = start; i < N; i++) {
            result[depth] = arr[i];
            dfs(depth + 1, i + 1);  // 다음 단계에서는 현재보다 오른쪽 숫자만 허용
        }
    }
    
}