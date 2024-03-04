import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][][] box;
    static Queue<Tomato> queue = new LinkedList<>();

    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    static int M, N, H;

    static class Tomato {
        int x, y, h;

        public Tomato(int h, int x, int y) {
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);
        H = Integer.parseInt(str[2]);

        box = new int[H][N][M];

        for(int h = 0; h < H; h++) {
            for(int n = 0; n < N; n++) {
                String[] line = br.readLine().split(" ");

                for(int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(line[m]);

                    if(box[h][n][m] == 1) {
                        queue.offer(new Tomato(h, n, m));
                    }
                }
            }
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            Tomato curTomato = queue.poll();

            for(int i = 0; i < 6; i++) {
                int nx = curTomato.x + dx[i];
                int ny = curTomato.y + dy[i];
                int nh = curTomato.h + dh[i];

                if(nx >= 0 && ny >= 0 && nh >= 0 && nx < N && ny < M && nh < H && box[nh][nx][ny] == 0) {
                    box[nh][nx][ny] = box[curTomato.h][curTomato.x][curTomato.y] + 1;
                    queue.offer(new Tomato(nh, nx, ny));
                }
            }
        }

        int maxDays = 0;
        for(int h = 0; h < H; h++) {
            for(int n = 0; n < N; n++) {
                for(int m = 0; m < M; m++) {
                    if(box[h][n][m] == 0) {
                        return -1;
                    }

                    maxDays = Math.max(maxDays, box[h][n][m]);
                }
            }
        }

        return maxDays - 1;
    }
}