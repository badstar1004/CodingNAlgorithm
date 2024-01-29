import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[N + 1];

        dp[0] = false;
        dp[1] = true;

        if (N >= 2) {
            dp[2] = false;
        }

        if (N >= 3) {
            dp[3] = true;
        }

        for(int i = 4; i <= N; i++) {
            dp[i] = !dp[i - 1] && !dp[i - 3];
        }
//
//        if(N % 2 == 0) {
//            System.out.println("CY");
//        } else {
//            System.out.println("SK");
//        }

        System.out.println(dp[N] ? "SK" : "CY");
    }
}