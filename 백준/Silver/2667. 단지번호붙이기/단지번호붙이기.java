import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            String brStr = br.readLine();

            for(int j = 0; j < N; j++) {
                map[i][j] = brStr.charAt(j) - '0';
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    resultList.add(bfs(i, j));
                }
            }
        }

        Collections.sort(resultList);
        System.out.println(resultList.size());
        for(int count : resultList) {
            System.out.println(count);
        }
    }

    private static int bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        map[i][j] = 0;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int k = 0; k < 4; k++) {
                int nx = curX + dx[k];
                int ny = curY + dy[k];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1) {
                    queue.offer(new int[] {nx, ny});
                    map[nx][ny] = 0;
                    count++;
                }
            }
        }

        return count;
    }
}