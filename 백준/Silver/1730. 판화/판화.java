import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        String cmdL = br.readLine();

        // 갈수있는지 여부
        int curRow = 0;
        int curCol = 0;

        // 방문 여부
        boolean[][] passVertical = new boolean[N][N];
        boolean[][] passHorizontal = new boolean[N][N];

        for (int i = 0; i < cmdL.length() ; i++) {
            char cmd = cmdL.charAt(i);

            if(cmd == 'D') {
                if(curRow == N - 1) {
                    continue;
                }

                // 이동한 칸과 이동할 칸
                passVertical[curRow][curCol] = passVertical[curRow + 1][curCol] = true;
                curRow++;

            } else if (cmd == 'U') {
                if(curRow == 0) {
                    continue;
                }

                // 이동한 칸과 이동할 칸
                passVertical[curRow][curCol] = passVertical[curRow - 1][curCol] = true;
                curRow--;

            } else if (cmd == 'L') {
                if(curCol == 0) {
                    continue;
                }

                // 이동한 칸과 이동할 칸
                passHorizontal[curRow][curCol] = passHorizontal[curRow][curCol - 1] = true;
                curCol--;

            } else {
                if(curCol == N - 1) {
                    continue;
                }

                // 이동한 칸과 이동할 칸
                passHorizontal[curRow][curCol] = passHorizontal[curRow][curCol + 1] = true;
                curCol++;
            }
        }

        for (int i = 0; i < N; i++) {
            String ans = "";
            for (int j = 0; j < N; j++) {
                if(passVertical[i][j] && passHorizontal[i][j]){
                    ans += "+";
                } else if (passVertical[i][j]) {
                    ans += "|";
                } else if (passHorizontal[i][j]) {
                    ans += "-";
                } else {
                    ans += ".";
                }
            }
            System.out.println(ans);
        }
    }
}