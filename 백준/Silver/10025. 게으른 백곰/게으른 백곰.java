import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 총 얼음 양동이 수
        int N = Integer.parseInt(st.nextToken());

        // 좌우로 떨어진 K
        int K = Integer.parseInt(st.nextToken());

        int maxBucket = 1_000_000;
        int[] arrIceBuckets = new int[maxBucket + 1];
        // 양동이 정보
        for(int i = 0; i < N; i++) {
            // 4 7 / 얼음 양, 양동이 위치
            st = new StringTokenizer(br.readLine());

            int iceAmount = Integer.parseInt(st.nextToken());
            int iceBucketPosition = Integer.parseInt(st.nextToken());

            arrIceBuckets[iceBucketPosition] = iceAmount;
        }

        int left = 0, right = 0;
        int curSum = 0, maxIce = 0;

        // 투 포인터
        while (right <= maxBucket) {
            // 양쪽 범위에 있다면
            if(right - left <= 2 * K) {
                curSum += arrIceBuckets[right];
                maxIce = Math.max(maxIce, curSum);

                right++;

            } else {
                curSum -= arrIceBuckets[left];
                left++;
            }
        }

        System.out.println(maxIce);
    }
}