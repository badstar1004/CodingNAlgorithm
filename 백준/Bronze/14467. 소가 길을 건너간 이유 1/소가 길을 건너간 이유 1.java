import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 관찰 횟수
        int N = Integer.parseInt(br.readLine());

        // 소 10마리의 위치 배열
        int[] position = new int[11];

        // 소 위치 초기화
        for(int i = 1; i <= 10; i++) {
            position[i] = -1;
        }

        // 길 건너는 횟수 저장
        int crossCount = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 소의 번호
            int curCowNumber = Integer.parseInt(st.nextToken());
            // 소의 위치
            int curCowPosition = Integer.parseInt(st.nextToken());

            // 이전 위치가 있고, 현재 위치와 다를 때
            if(position[curCowNumber] != -1 && position[curCowNumber] != curCowPosition) {
                crossCount++;
            }
            
            // 현재 위치로 변경
            position[curCowNumber] = curCowPosition;
        }

        System.out.println(crossCount);
    }
}