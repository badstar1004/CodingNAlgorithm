import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1}; // 상하좌우 이동
    static int[] dy = {1, -1, 0, 0}; // 상하좌우 이동

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, bfs(i, j));
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
    }

    public static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        int area = 0;

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            area++;

            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && matrix[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        return area;
    }
}