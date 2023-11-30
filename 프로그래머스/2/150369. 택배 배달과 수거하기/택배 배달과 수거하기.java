class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // 배달, 수거
        int delivery = 0, pickup = 0;
        
        // 마지막 집부터 시작
        for(int i = n - 1; i >= 0; i--) {
            delivery += deliveries[i];
            pickup += pickups[i];
            
            // 배달, 수거 중에 아직 있으면
            while(delivery > 0 || pickup > 0) {
                delivery -= cap;
                pickup -= cap;
                
                // (i + 1) => i + 1번째 집까지의 거리를 의미 / 2 => 왕복 
                answer += (i + 1) * 2; 
            }
        }
        
        return answer;
    }
}