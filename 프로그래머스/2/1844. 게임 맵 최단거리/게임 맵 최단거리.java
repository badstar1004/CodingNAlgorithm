import java.util.*;

class Solution {
    
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int N = maps.length;    // 행 길이
        int M = maps[0].length; // 열 길이

        // BFS 큐
        Queue<int[]> queue = new LinkedList<>();
        
        // 방문 여부
        boolean[][] visited = new boolean[N][M];

        // 시작위치 (0, 0) 추가
        queue.add(new int[] {0, 0});
        visited[0][0] = true;
        int lenght = 1;     // 시작위치 포함해 길이 1에서 시작

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int cx = cur[0];
                int cy = cur[1];

                if(cx == N - 1 && cy == M - 1) {
                    return lenght;
                }

                // 방향 체크
                for(int j = 0; j < 4; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];

                    if(nx >= 0 && nx < N && ny >= 0 && ny < M
                    && maps[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }

            lenght++;
        }

        return -1;
    }
}