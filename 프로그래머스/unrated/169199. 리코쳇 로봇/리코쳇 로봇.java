import java.util.*;

class Solution {
    
    // 방향 위, 오른쪽, 아래, 왼쪽
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    
    // 방향 클래스
    static class Position {
        int x, y, count;

        Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public int solution(String[] board) {
        int answer = 0;
        
        int n = board.length;
        int m = board[0].length();
        boolean[][] visited = new boolean[n][m];
        Queue<Position> queue = new LinkedList<>();
        
        Position start = null;
        Position goal = null;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // 시작위치
                if(board[i].charAt(j) == 'R') {
                    start = new Position(i, j, 0);
                
                // 목표위치
                } else if(board[i].charAt(j) == 'G') {
                    goal = new Position(i, j, -1);
                }
            }
        }
        
        queue.add(start);
        while(!queue.isEmpty()) {
            Position cur = queue.poll();
            
            // 위치가 같으면 종료
            if(cur.x == goal.x && cur.y == goal.y) {
                return cur.count;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = cur.x;
                int ny = cur.y;
                
                while(true) {
                    nx += dx[i];
                    ny += dy[i];
                    
                    // 방향이 작거나 크거나 또는 장애물일 경우
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx].charAt(ny) == 'D') {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }
                
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Position(nx, ny, cur.count + 1));

                    // 목적지에 도착한 경우
                    if(board[nx].charAt(ny) == 'G') {
                        return cur.count + 1;
                    }
                }
            }
        }
        
        return -1;
    }
}