import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> graph;
    static boolean[] visited;
    static int start, end, result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람 수
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 시작 사람
        start = Integer.parseInt(st.nextToken());
        // 목표 사람
        end = Integer.parseInt(st.nextToken());
        // 관계 수
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        // 초기화
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // DFS
        dfs(start, 0);
        // 출력
        System.out.println(result);
    }

    // DFS
    private static void dfs(int node, int depth) {
        if(node == end) {
            result = depth;
            return;
        }

        visited[node] = true;
        for(int next : graph.get(node)) {
            if(!visited[next]) {
                dfs(next, depth + 1);
            }
        }
    }
}
