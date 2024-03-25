import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수의 개수
        long N = Long.parseLong(br.readLine());
        System.out.println(binarySearch(N));
    }

    private static long binarySearch(long N) {
        long left = 0;
        long right = N;
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if(N <= Math.pow(mid, 2)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}