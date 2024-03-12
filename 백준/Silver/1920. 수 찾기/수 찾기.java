import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] line = br.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        // 정렬
        Arrays.sort(arr);

        // M개의 정수
        int M = Integer.parseInt(br.readLine());
        String[] searchLine = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            if(binarySearch(arr, Integer.parseInt(searchLine[i]))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    // 이분 탐색
    private static boolean binarySearch(int[] arr, int targetNumber) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(arr[mid] == targetNumber) {
                return true;
            } else if(arr[mid] < targetNumber) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}