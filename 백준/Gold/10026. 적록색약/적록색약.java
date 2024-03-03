import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();

            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int normalCount = countRegions(false);
        int weakCount = countRegions(true);

        System.out.println(normalCount + " " + weakCount);
    }

    private static int countRegions(boolean isColorWeakness) {
        visited = new boolean[N][N];

        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // 적록색약인 경우 R과 G를 동일하게 처리
                if(isColorWeakness && map[i][j] == 'G') {
                    map[i][j] = 'R';
                }

                if(!visited[i][j]) {
                    bfs(i, j, map[i][j], isColorWeakness);
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(int x, int y, char color, boolean isColorWeakness) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    if(isColorWeakness && (map[nx][ny] == color || color == 'R' && map[nx][ny] == 'G')) {
                        queue.offer(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    } else if(!isColorWeakness && map[nx][ny] == color) {
                        queue.offer(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}