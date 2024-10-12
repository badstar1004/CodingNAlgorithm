import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // 그래프 생성
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 전선 정보 추가
        for(int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        int minDiff = Integer.MAX_VALUE;
        
        // 전선 하나씩 끊음
        for(int[] wire: wires) {
            graph.get(wire[0]).remove((Integer) wire[1]);
            graph.get(wire[1]).remove((Integer) wire[0]);
            
            // 한쪽 계산 (bfs)
            boolean[] visited = new boolean[n + 1];
            int nodeCount = bfs(graph, visited, 1, n);
            
            // 차이 계산
            int diff = Math.abs(n - nodeCount - nodeCount);
            minDiff = Math.min(minDiff, diff);
            
            // 전선 복구
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
            
        }
        
        return minDiff;
    }
    
    
    // bfs
    public int bfs(List<List<Integer>> graph, boolean[] visited, int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        int count = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            
            for(int number : graph.get(node)) {
                if(!visited[number]) {
                    visited[number] = true;
                    queue.add(number);
                }
            }
        }
        
        return count;
    }
}