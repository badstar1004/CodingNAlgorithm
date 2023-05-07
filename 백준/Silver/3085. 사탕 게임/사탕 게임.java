import java.io.*;
import java.util.*;

public class Main {

    private static void swapCandy(char[][] map, int r1, int c1, int r2, int c2) {
        char temp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = temp;
    }

    private static int findMaxRow(char[][] map) {
        int N = map.length;
        int maxRow = 0;

        for (int i = 0; i < N; i++) {
            int len = 1;
            for (int j = 1; j < N; j++) {
                if(map[i][j] == map[i][j - 1]){
                    len++;

                } else {
                    maxRow = Math.max(maxRow, len);
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow, len);
        }

        return maxRow;
    }

    private static int findMaxCol(char[][] map) {
        int N = map.length;
        int maxCol = 0;

        for (int i = 0; i < N; i++) {
            int len = 1;
            for (int j = 1; j < N; j++) {
                if(map[j][i] == map[j - 1][i]){
                    len++;

                } else {
                    maxCol = Math.max(maxCol, len);
                    len = 1;
                }
            }
            maxCol = Math.max(maxCol, len);
        }

        return maxCol;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 오른쪽
                if(j + 1 < N && map[i][j] != map[i][j + 1]){
                    swapCandy(map, i, j, i, j + 1);
                    ans = Math.max(ans, Math.max(findMaxCol(map), findMaxRow(map)));
                    swapCandy(map, i, j, i, j + 1);
                }

                // 아래
                if(i + 1 < N && map[i][j] != map[i + 1][j]){
                    swapCandy(map, i, j, i + 1, j);
                    ans = Math.max(ans, Math.max(findMaxCol(map), findMaxRow(map)));
                    swapCandy(map, i, j, i + 1, j);
                }
            }
        }

        System.out.println(ans);
    }
}