import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 유클리드 호제
    private static int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수의 개수
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 왼쪽 -> 오른쪽, 오른쪽 -> 왼쪽 최대공약수 계산
        int[] gcdLeft = new int[N];
        int[] gcdRight = new int[N];

        gcdLeft[0] = arr[0];
        gcdRight[N - 1] = arr[N - 1];

        // 왼쪽에서 오른쪽으로 최대공약수를 계산하여 저장
        for(int i = 1; i < N; i++) {
            gcdLeft[i] = gcd(gcdLeft[i - 1], arr[i]);
        }

        // 오른쪽에서 왼쪽으로 최대공약수를 계산하여 저장
        for(int i = N - 2; i >= 0; i--) {
            gcdRight[i] = gcd(gcdRight[i + 1], arr[i]);
        }

        // 각 숫자를 제외한 최대공약수 계산
        int maxGCD = -1, removedNum = -1;
        for(int i = 0; i < N; i++) {
            int curGCD = 0;
            if (i == 0) {
                curGCD = gcdRight[1];

            } else if (i == N - 1) {
                curGCD = gcdLeft[N - 2];

            } else {
                curGCD = gcd(gcdLeft[i - 1], gcdRight[i + 1]);
            }

            // 최대공약수가 제거된 숫자의 약수가 아닌 경우에만 최대값을 갱신
            if (arr[i] % curGCD != 0 && maxGCD < curGCD) {
                maxGCD = curGCD;
                removedNum = arr[i];
            }
        }

        // 결과
        if(maxGCD == -1) {
            System.out.println(-1);
        } else {
            System.out.println(maxGCD + " " + removedNum);
        }

    }
}