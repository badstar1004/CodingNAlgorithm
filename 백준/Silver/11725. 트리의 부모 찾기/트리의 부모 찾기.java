import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 노드 개수
        int N = Integer.parseInt(br.readLine());
        
        // 트리 구조 리스트
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        
        // 간선 정보
        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            
            // 양쪽에 서로 추가
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }
        
        // 각 부모노드
        int[] arrParents = new int[N + 1];
        // 방문 여부
        boolean[] visited = new boolean[N + 1];
        // BFS 탐색 Queue
        Queue<Integer> queue = new LinkedList<>();
        // 루트노드 1번부터 시작
        queue.add(1);
        visited[1] = true;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(int num : tree.get(cur)) {
                if(!visited[num]) {
                    visited[num] = true;
                    arrParents[num] = cur;
                    queue.add(num);
                }
            }
        }
        
        // 부모 노드 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++) {
            sb.append(arrParents[i]).append('\n');
        }
        
        System.out.println(sb.toString());
    }
}