import java.io.*;

public class Main {
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            // 입력 마지막 -1 처리
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, w_function(a, b, c)));
        }

        System.out.print(sb);
    }

    static int w_function(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w_function(20, 20, 20);
        }

        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a < b && b < c) {
            dp[a][b][c] = 
                w_function(a, b, c - 1) + w_function(a, b - 1, c - 1) - w_function(a, b - 1, c);
        
        } else {
            dp[a][b][c] = 
                w_function(a - 1, b, c) + w_function(a - 1, b - 1, c) + w_function(a - 1, b, c - 1) - w_function(a - 1, b - 1, c - 1);
        }
        
        return dp[a][b][c];
    }
}