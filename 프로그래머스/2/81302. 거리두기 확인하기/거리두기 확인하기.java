import java.util.LinkedList;
import java.util.Queue;

// 위치 클래스
class Position {
    int x, y, distance;

    Position(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

class Solution {
    
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++) {
            if(isRightSit(places[i])) {
                answer[i] = 1;
                
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    // 자리 확인
    private static boolean isRightSit(String[] place) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(place[i].charAt(j) == 'P') {
                    if(!bfs(i, j, place)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    // BFS (x, y, 위치)
    private static boolean bfs(int x, int y, String[] place) {
        boolean[][] visited = new boolean[5][5];
        Queue<Position> queue = new LinkedList<>();
        
        // 처음 값
        visited[x][y] = true;
        queue.offer(new Position(x, y, 0));
        
        while(!queue.isEmpty()) {
            Position cur = queue.poll();
            
            if(cur.distance > 2) {
                continue;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nx][ny]) {
                    if(place[nx].charAt(ny) == 'P') {
                        if(cur.distance == 0) {
                            return false;
                            
                        } else if(cur.distance == 1) {
                            if(place[cur.x].charAt(cur.y) != 'X') {
                                return false;
                            }
                        }
                    }
                    
                    visited[nx][ny] = true;
                    if(place[nx].charAt(ny) != 'X' && cur.distance < 2) {
                        queue.offer(new Position(nx, ny, cur.distance + 1));
                    }
                }
            }
        }
        return true;
    }
}