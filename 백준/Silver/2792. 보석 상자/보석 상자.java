import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 아이들 수
        int N = Integer.parseInt(st.nextToken());

        // 색상의 수
        int M = Integer.parseInt(st.nextToken());

        int[] jewels = new int[M];
        int maxJewel = 0;
        for(int i = 0; i < M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            // 제일 큰 보석 수
            maxJewel = Math.max(maxJewel, jewels[i]);
        }

        System.out.println(findMinJealousy(N, jewels, maxJewel));
    }

    private static int findMinJealousy(int N, int[] jewels, int maxJewel) {
        int left = 1, right = maxJewel;

        while(left < right) {
            int midJewel = left + (right - left) / 2;

            if(canDistribute(N, jewels, midJewel)) {
                right = midJewel;
            } else {
                left = midJewel + 1;
            }
        }

        return left;
    }

    private static boolean canDistribute(int N, int[] jewels, int midJewel) {
        int count = 0;
        for(int jewel : jewels) {
            count += jewel / midJewel;

            if(jewel % midJewel != 0) {
                count++;
            }
        }

        return count <= N;
    }
}