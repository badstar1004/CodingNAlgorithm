class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        // 전파 범위
        int range = 2 * w + 1;
        
        int start = 1;
        for(int station : stations) {
            // 현재 아파트부터 기지국이 도달하지 않는 구간까지 계산
            if(start < station - w) {
                int unRange = station - w - start;
                
                // 필요한 기지국 수
                answer += Math.ceil((double) unRange / range);
            }
            
            // 다음 탐색 시작 지점 = 기지국 범위 다음부터
            start = station + w + 1;
        }
        
        // 마지막 기지국 이후 남은 아파트가 있으면
        if(start <= n) {
            int unRange = n - start + 1;
            answer += Math.ceil((double) unRange / range);
        }

        return answer;
    }
}