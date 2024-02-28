import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 모눈종이 M
        M = Integer.parseInt(st.nextToken());
        // 모눈종이 N
        N = Integer.parseInt(st.nextToken());
        // 직사각형 개수
        K = Integer.parseInt(st.nextToken());

        paper = new int[M][N];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            markRectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
            , Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        List<Integer> areas = new ArrayList<>();
        for(int y = 0; y < M; y++) {
            for(int x = 0; x < N; x++) {
                if(paper[y][x] == 0) {
                    areas.add(bfs(y, x));
                }
            }
        }

        Collections.sort(areas);
        // 사각형 개수
        System.out.println(areas.size());

        // 각 크기
        for (int area : areas) {
            System.out.print(area + " ");
        }
    }

    // bfs
    private static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y, x});
        paper[y][x] = -1;
        int area = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            area++;

            for(int[] d : new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int ny = cur[0] + d[0];
                int nx = cur[1] + d[1];

                if(ny >= 0 && ny < M && nx >= 0 && nx < N && paper[ny][nx] == 0) {
                    queue.add(new int[] {ny, nx});
                    paper[ny][nx] = -1;
                }
            }
        }

        return area;
    }

    // 직사각형 좌표
    private static void markRectangle(int lx, int ly, int rx, int ry) {
        for (int y = ly; y < ry; y++) {
            for (int x = lx; x < rx; x++) {
                if (x < N && y < M) {
                    paper[y][x] = 1;
                }
            }
        }
    }
}