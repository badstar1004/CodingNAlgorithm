import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 소의 수
        int N = Integer.parseInt(br.readLine());

        // 소 배열
        int[][] cows = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(cows, Comparator.comparingInt(a -> a[0]));

        // 현재 시간
        int curTime = 0;

        // 순서대로 처리
        for(int i = 0; i < N; i++) {
            int arrival = cows[i][0];
            int inspectionTime = cows[i][1];

            // 소가 도착 했을 때 현재 시간과 비교
            if(arrival > curTime) {
                curTime = arrival;
            }

            curTime += inspectionTime;
        }

        System.out.println(curTime);
    }
}