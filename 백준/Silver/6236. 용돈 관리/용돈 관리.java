import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 쓸 날 일수, 돈 빼는 수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] moneys = new int[N];

        int left = 0, right = 0;
        for(int i = 0; i < N; i++) {
            moneys[i] = Integer.parseInt(br.readLine());
            right += moneys[i];

            // 최소 인출 금액은 가장 큰 지출을 커버할 수 있어야 함
            if(moneys[i] > left) {
                left = moneys[i];
            }
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 모든 날의 금액을 커버할 수 있는지 여부
            if(canCoverMoney(moneys, mid, M)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);

    }

    private static boolean canCoverMoney(int[] moneys, int mid, int M) {
        int count = 1;      // 인출 횟수, 처음 인출
        int curMoney = mid;

        for(int money : moneys) {
            if(curMoney >= money) {
                curMoney -= money;
            } else {
                curMoney = mid - money;
                count++;
            }
        }

        return count <= M;
    }
}