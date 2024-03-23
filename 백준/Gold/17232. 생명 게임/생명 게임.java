import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 기준이 되는 정수
        int K = Integer.parseInt(st.nextToken());
        // 다음 상황을 결정
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // T 시간 동안 관찰
        for(int i = 0; i < T; i++) {
            board = getNextState(board, N, M, K, a, b);
        }

        // 출력
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    private static char[][] getNextState(char[][] board, int N, int M, int K, int a, int b) {
        char[][] nextBoard = new char[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int lifeCount = countLives(board, N, M, i, j, K);

                // 현재칸이 생존이라면
                if(board[i][j] == '*') {
                    // 생존
                    if(lifeCount >= a && lifeCount <= b) {
                        nextBoard[i][j] = '*';

                    } else {        // 고독 또는 과밀
                        nextBoard[i][j] = '.';
                    }
                } else {        // 현재칸이 생존이 아니라면
                    if(lifeCount > a && lifeCount <= b) {
                        nextBoard[i][j] = '*';
                    } else {
                        nextBoard[i][j] = '.';
                    }
                }
            }
        }

        return nextBoard;
    }

    private static int countLives(char[][] board, int N, int M, int x, int y, int K) {
        int count = 0;

        for(int i = -K; i <= K; i++) {
            for(int j = -K; j <= K; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }

                int nx = x + i;
                int ny = y + j;
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == '*') {
                    count++;
                }
            }
        }

        return count;
    }
}