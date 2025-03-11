import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컴퓨터 개수
        int N = Integer.parseInt(br.readLine());
        // 연결 개수
        int M = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList<>(N + 1);
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N + 1];
        
        // 출력 / 1번 컴퓨터 제외
        System.out.println(bfs(1) - 1);
    }

    // BFS
    private static int bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(start);
        visited[start] = true;
        int count = 0;

        while(!deque.isEmpty()) {
            int node = deque.poll();
            count++;

            for(int next : graph.get(node)) {
                if(!visited[next]) {
                    visited[next] = true;
                    deque.offer(next);
                }
            }
        }

        return count;
    }
}
