import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int t = 1; t <= 10; t++) {
            // 건물 개수
            int N = Integer.parseInt(br.readLine());
            
            // 각 건물 높이 저장 배열
            int[] arrBuildings = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
            	arrBuildings[i] = Integer.parseInt(st.nextToken());
            }
            
            // 조망권 수
            int totalViewCount = 0;
            // 2번째 건물부터 N-3번째 건물까지 (양끝 2칸 제외)
            for (int i = 2; i < N - 2; i++) {
            	// 가장 높은 높이 구하기
                int maxLeftRight = Math.max(
                	Math.max(arrBuildings[i - 2], arrBuildings[i - 1]),
                    Math.max(arrBuildings[i + 1], arrBuildings[i + 2])
                );
                
                // 현재 빌딩이 주변 빌딩들보다 높으면 조망권 확보
                if (arrBuildings[i] > maxLeftRight) {
                    // 조망권 세대수 계산
                	totalViewCount += arrBuildings[i] - maxLeftRight;
                }
            }
            
            System.out.println("#" + t + " " + totalViewCount);
        }
    }
}