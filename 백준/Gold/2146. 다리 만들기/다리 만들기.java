import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        /*
         * 고유 번호 할당
         * */
        int islandId = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, islandId++);
                }
            }
        }

        /*
         * 다른 섬까지 최소 거리 계산
         * */
        int answer = Integer.MAX_VALUE;
        for (int i = 2; i < islandId; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(visited[j], false);
            }
            answer = Math.min(answer, bridge(i));
        }

        System.out.println(answer);
    }

    /*
     * BFS 사용
     * 각 섬에 고유 번호를 할당
     * */
    private static void bfs(int x, int y, int islandId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = islandId;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        map[nx][ny] = islandId;
                    }
                }
            }
        }
    }

    /*
     * 다른 섬까지 최소 거리 계산
     * */
    private static int bridge(int islandId) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == islandId) {
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map[nx][ny] != 0 && map[nx][ny] != islandId) {
                        return cur[2];
                    }
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        queue.offer(new int[]{nx, ny, cur[2] + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }

}