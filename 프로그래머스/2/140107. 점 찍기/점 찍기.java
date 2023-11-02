class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        // 제곱 값을 한 번만 계산하고 재사용
        long dSquared = (long) d * d;
        long longK = k;
        
        /*
            원점 (0, 0)으로부터 어떤 점 (x, y)까지의 거리 (피타고라스의 정리 사용)
            단, d를 넘으면 안됨
            x^2 + y^2 <= d^2 -> 각각 k의 배수이므로 (xk)^2 + (yk)^2 <= d^2
            각 x 값에 대해 y 값을 계산하면서 이 조건을 만족하는 점들의 개수를 세는 방식을 사용
            y^2 = Math.sqrt(d^2 - (x^2k^2)) / k + 1 
        */
        for(long x = 0; x * longK <= d; x++) {
            // y의 최대 실수 값을 계산
            double maxY = Math.sqrt(dSquared - (x * x * longK * longK));
            
            // 실수 값을 long으로 캐스팅
            answer += (long) (maxY / longK) + 1; // 0 포함을 위해 +1
        }
        
        return answer;
    }
}