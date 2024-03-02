import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            String[] str = br.readLine().split(" ");
            // 가로
            M = Integer.parseInt(str[0]);
            // 세로
            N = Integer.parseInt(str[1]);
            // 배추 개수
            K = Integer.parseInt(str[2]);

            map = new int[M][N];
            visited = new boolean[M][N];

            for(int i = 0; i < K; i++) {
                String[] dir = br.readLine().split(" ");
                int x = Integer.parseInt(dir[0]);
                int y = Integer.parseInt(dir[1]);

                map[x][y] = 1;
            }

            int wormCount = 0;
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        wormCount++;
                    }
                }
            }

            System.out.println(wormCount);
        }
    }

    private static void bfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    bfs(nx, ny);
                }
            }
        }
    }
}