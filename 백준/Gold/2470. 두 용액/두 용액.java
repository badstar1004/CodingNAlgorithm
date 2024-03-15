import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        // 정렬
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int minDiff = Integer.MAX_VALUE;
        int result1 = 0, result2 = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int absSum = Math.abs(sum);

            // 합이 최소값보다 작으면 업데이트
            if(absSum < minDiff) {
                minDiff = absSum;
                result1 = arr[left];
                result2 = arr[right];
            }

            if(sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(result1 + " " + result2);
    }
}