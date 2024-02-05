import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 구매하려는 카드 개수
        int N = Integer.parseInt(br.readLine());

        // 카드 가격
        String[] input = br.readLine().split(" ");

        // 카드 가격이 담긴 cardPack (인덱스 1부터)
        int[] cardPack = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            cardPack[i] = Integer.parseInt(input[i - 1]);
        }

        // dp
        int[] dp = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + cardPack[j]);
            }
        }

        System.out.println(dp[N]);
    }
}