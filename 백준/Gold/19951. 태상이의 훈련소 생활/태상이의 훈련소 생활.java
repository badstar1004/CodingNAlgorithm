import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        // 테스트 케이스
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 차분배열
        int[] difference = new int[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken());
            int targetNumber = Integer.parseInt(st.nextToken());

            difference[start] += targetNumber;
            if(end < N) {
                difference[end] -= targetNumber;
            }
        }

        // 차분 배열을 이용한 누적합 계산
        int curSum = 0;
        for(int i = 0; i < N; i++) {
            curSum += difference[i];
            arr[i] += curSum;
        }
        
        // 결과
        for(int result : arr) {
            System.out.print(result + " ");
        }
    }
}