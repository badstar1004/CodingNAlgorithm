import java.util.LinkedList;
import java.util.Queue;

// 위치 클래스
class Position {
    int x;
    int y;
    int time;

    Position(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        int answer = 0;
        
        /*
            최단경로
                bfs
        */
        
        int n = maps.length;
        int m = maps[0].length();
        
        // 시작점, 레버
        Position start = null, lever = null;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(maps[i].charAt(j) == 'S') {
                    start = new Position(i, j, 0);
                    
                } else if(maps[i].charAt(j) == 'L') {
                    lever = new Position(i, j, 0);
                }
            }
        }
        
        // 출발부터 레버까지 가는 시간
        int toLever = bfs(maps, start, 'L');
        if(toLever == -1) {
            return -1;
        }
        
        // 레버부터 출구까지 가는 시간
        int toExit = bfs(maps, lever, 'E');
        if(toExit == -1) {
            return -1;
        }
        
        return toLever + toExit;
    }
    
    // bfs (미로, 시작위치, 타겟 문자)
    public static int bfs(String[] maps, Position start, char target) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        
        Queue<Position> queue = new LinkedList<>();
        // 시작위치 넣기
        queue.offer(start);
        visited[start.x][start.y] = true;
        
        while(!queue.isEmpty()) {
            Position curPosition = queue.poll();
            
            if (maps[curPosition.x].charAt(curPosition.y) == target) {
                return curPosition.time;
            }
            
            // 방향 체크
            for(int i = 0; i < 4; i++) {
                int nx = curPosition.x + dx[i];
                int ny = curPosition.y + dy[i];
                
                if(nx >= 0 && nx < n
                    && ny >= 0 && ny < m
                    && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {    // 방문 x, 벽이 아닐 때
                    visited[nx][ny] = true;
                    queue.offer(new Position(nx, ny, curPosition.time + 1));
                }
            }
        }
        
        return -1;
    }
}