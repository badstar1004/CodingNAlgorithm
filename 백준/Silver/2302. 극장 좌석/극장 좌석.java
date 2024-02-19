import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전체 좌석 수
        int N = Integer.parseInt(br.readLine());

        // VIP 좌석 수
        int vipCount = Integer.parseInt(br.readLine());

        // VIP 배열
        int[] vipArr = new int[vipCount + 2];

        vipArr[0] = 0;  // 시작
        vipArr[vipCount + 1] = N + 1;
        for(int i = 1; i <= vipCount; i++) {
            vipArr[i] = Integer.parseInt(br.readLine());
        }

        // System.out.println("vipArr: " + Arrays.toString(vipArr));

        // dp
        int[] dp = new int[41];

        // 피보나치
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int result = 1;
        for(int i = 0; i <= vipCount; i++) {
            int gap = vipArr[i + 1] - vipArr[i] - 1;
            // System.out.println("i: " + i);
            // System.out.println("vipArr[i + 1]: " + vipArr[i + 1]);
            // System.out.println("vipArr[i]: " + vipArr[i]);
            result *= dp[gap];
        }

        System.out.println(result);
    }
}