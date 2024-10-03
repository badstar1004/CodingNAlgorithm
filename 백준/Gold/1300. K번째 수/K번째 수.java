import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열 크기
        int N = Integer.parseInt(br.readLine());

        // k번째 수
        int k = Integer.parseInt(br.readLine());

        // 이분 탐색 범위 설정
        long left = 1;
        long right = (long) N * N;
        long result = 0;

        // 이분 탐색
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = 0;

            // mid보다 작거나 같은 수의 개수 계산
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);  // 각 행에서 mid보다 작거나 같은 수 개수 더함
            }

            // count가 k 이상인 경우 (k번째 수는 mid 또는 그 이하에 존재)
            if (count >= k) {
                result = mid;  // mid를 저장하고
                right = mid - 1;  // 더 작은 범위를 탐색
            } else {
                left = mid + 1;  // 더 큰 범위를 탐색
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}