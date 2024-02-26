import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Point {
        // 층, 행, 열
        int l, r, c;

        public Point(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }

    // 입력 받는 변수 (층, 행, 열)
    static int L, R, C;
    // 상범 빌딩
    static char[][][] building;
    // 방문여부
    static boolean[][][] visited;
    // 층, 행, 열 방향
    // 위층, 아래층
    static int[] dl = {1, -1, 0, 0, 0, 0};
    // 위행, 아래행
    static int[] dr = {0, 0, 1, -1, 0, 0};
    // 오른쪽, 왼쪽
    static int[] dc = {0, 0, 0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                continue;
            }

            String[] split = line.split(" ");
            L = Integer.parseInt(split[0]);
            R = Integer.parseInt(split[1]);
            C = Integer.parseInt(split[2]);

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            building = new char[L][R][C];
            visited = new boolean[L][R][C];
            Point start = null;

            // 상범 빌딩 건설
            for (int l = 0; l < L; l++) {
                // 층 사이의 빈 줄을 읽어 넘김
                if (l > 0) {
                    br.readLine();
                }

                for (int r = 0; r < R; r++) {
                    line = br.readLine();

                    for (int c = 0; c < C; c++) {
                        building[l][r][c] = line.charAt(c);

                        if (building[l][r][c] == 'S') {
                            start = new Point(l, r, c);
                        }
                    }
                }
            }

            int x = bfs(start);
            if (x == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + (x) + " minute(s).");
            }
        }
    }

    // BFS
    private static int bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        // 방문 여부 체크
        visited[start.l][start.r][start.c] = true;
        // 최단 시간
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();

                assert cur != null;
                if (building[cur.l][cur.r][cur.c] == 'E') {
                    return time;
                }

                for (int j = 0; j < 6; j++) {
                    int nl = cur.l + dl[j];
                    int nr = cur.r + dr[j];
                    int nc = cur.c + dc[j];

                    if (nl >= 0 && nl < L
                            && nr >= 0 && nr < R
                            && nc >= 0 && nc < C) {
                        if (!visited[nl][nr][nc] && building[nl][nr][nc] != '#') {
                            visited[nl][nr][nc] = true;
                            queue.add(new Point(nl, nr, nc));
                        }
                    }
                }
            }

            time++;
        }

        return -1;
    }
}