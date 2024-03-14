import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N
        int N = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        // 입력 수열
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(line[i - 1]);
        }

        int[] dp = new int[N + 1];      // dp -> 증가된 수열의 길이
        int[] trace = new int[N + 1];   // trace -> 증가되는 수 인덱스 저장

        // trace 배열 -1로 초기화
        java.util.Arrays.fill(trace, -1);

        for (int i = 1; i <= N; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    trace[i] = j;
                }
            }
        }

        int maxIndex = 1;
        for (int i = 1; i <= N; i++) {
            if (dp[maxIndex] < dp[i]) {
                maxIndex = i;
            }
        }
        
        // 최대 길이
        System.out.println(dp[maxIndex]);

        Stack<Integer> stack = new Stack<>();
        while (maxIndex != -1) {
            stack.push(arr[maxIndex]);
            maxIndex = trace[maxIndex];
        }

        // 수열 출력
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}