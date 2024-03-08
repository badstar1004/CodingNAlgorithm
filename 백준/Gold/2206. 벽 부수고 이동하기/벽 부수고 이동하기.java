import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Point {
        int x, y;
        boolean destroyed;
        int count;

        public Point(int x, int y, boolean destroyed, int count) {
            this.x = x;
            this.y = y;
            this.destroyed = destroyed;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        map = new int[N][M];
        visited = new boolean[N][M][2];     // 0, 1 => 벽 부순 유무 | x, o

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, false, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();

            // 탈출 조건
            if (curPoint.x == N - 1 && curPoint.y == M - 1) {
                return curPoint.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curPoint.x + dx[i];
                int ny = curPoint.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                // 벽 부순 유무 확인
                if (curPoint.destroyed) {
                    // 다음 지점이 벽이 아니고, 방문한 적이 없다면 큐에 넣음
                    if (map[nx][ny] == 0 && !visited[nx][ny][1]) {
                        queue.offer(new Point(nx, ny, true, curPoint.count + 1));
                        visited[nx][ny][1] = true;
                    }

                } else {
                    // 다음 지점이 벽인지 확인
                    if(map[nx][ny] == 1) {
                        // 벽을 부수고 큐에 넣음
                        queue.offer(new Point(nx, ny, true, curPoint.count + 1));
                        visited[nx][ny][1] = true;

                    } else if(!visited[nx][ny][0]) {
                        queue.offer(new Point(nx, ny, false, curPoint.count + 1));
                        visited[nx][ny][0] = true;
                    }
                }
            }
        }

        return -1;
    }
}