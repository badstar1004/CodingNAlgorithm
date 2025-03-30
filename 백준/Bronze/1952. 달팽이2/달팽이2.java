import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[M][N];
        // 우, 하, 좌, 상
        int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상
        int[] dy = {1, 0, -1, 0};
        
        int x = 0, y = 0, dir = 0, num = 1;
        int turnCount = 0;
        
        while(num <= M * N) {
            map[x][y] = num++;
            
            // 마지막 방향 전환 x
            if(num > M * N) {
                break;
            }
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            // 칸이 범위를 벗어나거나 채워졌으면 방향 전환
            if(nx < 0 || ny < 0 || nx >= M || ny >= N || map[nx][ny] != 0) {
                // 방향 전환
                dir = (dir + 1) % 4;
                turnCount++;
                
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            
            x = nx;
            y = ny;
        }
        
                // 출력: 배열
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
        
        // 출력: 방향 전환 횟수
        System.out.println(turnCount);
    }
}