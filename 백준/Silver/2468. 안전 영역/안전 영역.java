import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //  2차원 배열의 행과 열의 개수
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];

        int maxArea = 1;    // 비가 전혀 오지 않는 경우 기본값
        int minHeight = 100, maxHeight = 1;

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            for(int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(line[j]);
                minHeight = Math.min(minHeight, area[i][j]);
                maxHeight = Math.max(maxHeight, area[i][j]);
            }
        }

        for(int h = minHeight; h < maxHeight; h++) {
            visited = new boolean[N][N];
            int safeArea = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(area[i][j] > h && !visited[i][j]) {
                        dfs(i, j, h);
                        safeArea++;
                    }
                }
            }

            maxArea = Math.max(maxArea, safeArea);
        }

        System.out.println(maxArea);
    }

    private static void dfs(int x, int y, int h) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(area[nx][ny] > h && !visited[nx][ny]) {
                    dfs(nx, ny, h);
                }
            }
        }
    }
}