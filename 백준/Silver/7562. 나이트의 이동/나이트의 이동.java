import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Position {
        int x, y, count;

        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static boolean[][] visited;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static int l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];

            // 시작 위치
            String[] startPositionsLine = br.readLine().split(" ");
            Position startPosition =
                    new Position(Integer.parseInt(startPositionsLine[0]), Integer.parseInt(startPositionsLine[1]), 0);

            // 끝 위치
            String[] endPositionsLine = br.readLine().split(" ");
            Position endPosition =
                    new Position(Integer.parseInt(endPositionsLine[0]), Integer.parseInt(endPositionsLine[1]), 0);

            System.out.println(bfs(startPosition, endPosition));

        }

    }

    private static int bfs(Position startPosition, Position endPosition) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(startPosition);
        visited[startPosition.x][startPosition.y] = true;

        while (!queue.isEmpty()) {
            Position curPosition = queue.poll();

            if(curPosition.x == endPosition.x && curPosition.y == endPosition.y) {
                return curPosition.count;
            }

            for(int i = 0; i < 8; i++) {
                int nx = curPosition.x + dx[i];
                int ny = curPosition.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < l && ny < l && !visited[nx][ny]) {
                    queue.offer(new Position(nx, ny, curPosition.count + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }
}