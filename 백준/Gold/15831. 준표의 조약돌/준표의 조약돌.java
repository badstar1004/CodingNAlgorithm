import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 총 개수
        int N = Integer.parseInt(st.nextToken());

        // 검정 조약돌
        int B = Integer.parseInt(st.nextToken());

        // 흰 조약돌
        int W = Integer.parseInt(st.nextToken());

        int maxLen = 0;
        int countB = 0, countW = 0;
        int left = 0;

        String stones = br.readLine();
        for(int right = 0; right < N; right++) {
            if (stones.charAt(right) == 'B') {
                countB++;
            }
            if (stones.charAt(right) == 'W') {
                countW++;
            }

            while (countB > B) {
                if (stones.charAt(left) == 'B') {
                    countB--;
                }
                if (stones.charAt(left) == 'W'){
                    countW--;
                }

                left++;
            }

            if (countW >= W) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        System.out.println(maxLen);
    }
}