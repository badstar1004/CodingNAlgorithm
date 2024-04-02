import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 집의 개수, 공유기 개수
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] homeArr = new int[N];
        for(int i = 0; i < N; i++) {
            homeArr[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(homeArr);

        int minDistant = 1;     // 가능한 최소 거리
        int maxDistant = homeArr[N - 1] - homeArr[0];       // 가능한 최대 거리
        int result = 0;

        while(minDistant <= maxDistant) {
            int midDistant = minDistant + (maxDistant - minDistant) / 2;        // 중간거리
            int installed = 1;      // 설치된 공유기 수 (첫번째집에 설치한다 가정)
            int lastInstalled = homeArr[0];     // 마지막으로 공유기를 설치한 집

            for(int i = 1; i < N; i++) {
                if(homeArr[i] - lastInstalled >= midDistant) {
                    installed++;
                    lastInstalled = homeArr[i];
                }
            }

            if(installed >= C) {
                minDistant = midDistant + 1;
                result = midDistant;
            } else {
                maxDistant = midDistant - 1;
            }
        }

        System.out.println(result);
    }
}