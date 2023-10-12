import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        // 카메라 설치 위치 초기화
        int camera = Integer.MIN_VALUE;

        for (int[] route : routes) {
            // 현재 차량의 진입 지점이 이전에 설치한 카메라의 위치보다 클 경우
            // 즉, 현재 차량이 이전 카메라에 포착되지 않을 경우
            if (camera < route[0]) {
                // 현재 차량의 나가는 지점에 카메라 설치
                camera = route[1];
                answer++;
            }
        }

        return answer;
    }
}