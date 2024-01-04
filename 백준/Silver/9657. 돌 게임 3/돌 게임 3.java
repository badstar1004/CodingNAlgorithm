import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[N + 1];
        dp[0] = false;      // 돌이 없으면 진것으로 간주

        for(int i = 1; i <= N; i++) {
            dp[i] = (i >= 1 && !dp[i - 1]) || (i >= 3 && !dp[i - 3]) || (i >= 4 && !dp[i - 4]);
        }

//        System.out.println(Arrays.toString(dp));

        System.out.println(dp[N] ? "SK" : "CY");
    }
}