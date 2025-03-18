import java.util.*;
import java.io.*;

class Main {
    
    // N: 도시 개수, M: 도로 개수, K: 거리 정보, X: 출발 도시 번호 
    static int N, M, K, X;
    static List<List<Integer>> graph;
    static int[] distance;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N: 도시 개수, M: 도로 개수, K: 거리 정보, X: 출발 도시 번호 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        // 리스트 초기화
        graph = new ArrayList<>();
        
        // 거리 초기화
        distance = new int[N + 1];
        Arrays.fill(distance, -1); 
        
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(b);
        }
        
        // BFS
        bfs(X);
        
        boolean found = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(distance[i] == K) {
                sb.append(i).append("\n");
                found = true;
            }
        }
        
        System.out.println(found ? sb : "-1");
    }
    
    // BFS
    public static void bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(start);
        distance[start] = 0;
        
        while(!deque.isEmpty()) {
            int cur = deque.poll();
            
            for(int next : graph.get(cur)) {
                if(distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
                    deque.offer(next);
                }
            }
        }
    }
}