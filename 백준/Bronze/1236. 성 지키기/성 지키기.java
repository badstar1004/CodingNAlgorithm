import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }   // O(N * M)

        // 1. 행/열에 대해 경비원이 있는지 확인
        boolean[] existRow = new boolean[N];
        boolean[] existCol = new boolean[M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'X'){
                    existRow[i] = true;
                    existCol[j] = true;
                }   // O(N * M)
            }
        }

        // 2. 보호받지 못하는 행/열의 개수
        int needRowCount = N;
        int needColCount = M;
        for (int i = 0; i < N; i++) {
            if(existRow[i]){
                needRowCount--;
            }   // O(N)
        }

        for (int i = 0; i < M; i++) {
            if(existCol[i]){
                needColCount--;
            }   // O(M)
        }

        // O(N * M) + O(N * M) + O(N) + O(M) = O(NM)
        // 3. 둘중 큰 값 출력
        System.out.println(Math.max(needRowCount, needColCount));
    }
}