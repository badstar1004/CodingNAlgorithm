import java.io.*;
import java.util.*;

// Point
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    
    static int[][] arr;
    static int N;
    static int M;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs(0, 0));
    }
    
    // BFS
    private static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            
            // 탈출 조건
            if(point.x == N - 1 && point.y == M - 1) {
                return arr[point.x][point.y];
            }
            
            // 검사
            for(int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(arr[nx][ny] != 0 && !visited[nx][ny]) {
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                        arr[nx][ny] = arr[point.x][point.y] + 1;
                    }
                }
            }
        }
        
        return -1;
    }
}