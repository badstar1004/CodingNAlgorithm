import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        
        // 달팽이 이차배열
        int[][] map = new int[N][N];
        // 상, 우, 하, 좌
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        // 시작은 중앙에서
        int x = N / 2, y = N / 2;
        int num = 1;
        map[x][y] = num++;
        
        // 이동 칸수
        int step = 1;
        // 방향 인덱스
        int dir = 0;
        // target 좌표
        int targetX = x, targetY = y;
        
        while (num < N * N) {
            // 한 step씩 두 방향 (상우, 하좌) 반복
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < step; j++) {
                    x += dx[dir];
                    y += dy[dir];

                    if (x < 0 || y < 0 || x >= N || y >= N) {
                        continue;
                    }

                    map[x][y] = num;
                    if (num == target) {
                        targetX = x;
                        targetY = y;
                    }
                    num++;
                }

                // 방향 전환
                dir = (dir + 1) % 4;
            }

            step++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int[] row : map) {
            for(int value : row) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        
        sb.append((targetX + 1)).append(" ").append((targetY + 1));
        System.out.println(sb);
    }
}