import java.io.*;
import java.util.*;

public class Main {

    // N: 정점의 개수, M: 간선의 개수, V: 시작 정점의 번호
    static int N, M, V;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            // 각 정점에 대한 List 생성
            graph.add(new ArrayList<>());
        }

        // 간선 정보
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 작은것부터 정렬
        for(int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS
        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        // BFS
        visited = new boolean[N + 1];
        bfs(V);

        // 출력
        System.out.println(sb);
    }

    // DFS
    private static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");

        for(int next : graph.get(node)) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    // BFS (ArrayDeque 사용)
    private static void bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(start);
        visited[start] = true;

        while(!deque.isEmpty()) {
            int node = deque.poll();
            sb.append(node).append(" ");

            for(int next : graph.get(node)) {
                if(!visited[next]) {
                    visited[next] = true;
                    deque.offer(next);
                }
            }
        }
    }
}
