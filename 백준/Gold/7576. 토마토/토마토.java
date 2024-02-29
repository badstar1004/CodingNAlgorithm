import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Tomato {
        int x;
        int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] mnStr = br.readLine().split(" ");
        int M = Integer.parseInt(mnStr[0]);
        int N = Integer.parseInt(mnStr[1]);

        int[][] box = new int[N][M];
        Queue<Tomato> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");

            for(int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(row[j]);
                if(box[i][j] == 1) {
                    queue.offer(new Tomato(i, j));
                }
            }
        }

        System.out.println(bfs(box, queue, N, M));
    }

    private static int bfs(int[][] box, Queue<Tomato> queue, int N, int M) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Tomato curTomato = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = curTomato.x + dx[i];
                int ny = curTomato.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && box[nx][ny] == 0) {
                    box[nx][ny] = box[curTomato.x][curTomato.y] + 1;
                    queue.offer(new Tomato(nx, ny));
                }
            }
        }

        // 결과
        int days = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
                days = Math.max(days, box[i][j]);
            }
        }

        return days - 1;
    }
}