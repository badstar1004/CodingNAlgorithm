import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int F = Integer.parseInt(input[0]);     // 전체 층
        int S = Integer.parseInt(input[1]);     // 시작 층
        int G = Integer.parseInt(input[2]);     // 끝 층
        int U = Integer.parseInt(input[3]);     // 위층
        int D = Integer.parseInt(input[4]);     // 아래층

        System.out.println(dfs(F, S, G, U, D));
    }

    private static String dfs(int F, int S, int G, int U, int D) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[F + 1];

        queue.offer(new int[]{S, 0});      // 현재 층과 버튼 누른 횟수
        visited[S] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curFloor = cur[0];
            int buttonCount = cur[1];

            if (curFloor == G) {
                return String.valueOf(buttonCount);
            }

            int upFloor = curFloor + U;
            int downFloor = curFloor - D;

            if (upFloor <= F && !visited[upFloor]) {
                queue.offer(new int[]{upFloor, buttonCount + 1});
                visited[upFloor] = true;
            }

            if (downFloor >= 1 && !visited[downFloor]) {
                queue.offer(new int[]{downFloor, buttonCount + 1});
                visited[downFloor] = true;
            }
        }

        return "use the stairs";
    }
}