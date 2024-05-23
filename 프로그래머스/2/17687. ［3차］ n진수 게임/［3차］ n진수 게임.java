class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder answer = new StringBuilder();
        StringBuilder total = new StringBuilder();
        
        // 게임 참가자 인원 모두 고려
        int totalLen = t * m;
        
        // 0부터 숫자를 구해가면서 특정 진법으로 변환한 결과를 total에 추가
        int num = 0;
        while(total.length() < totalLen) {
            total.append(Integer.toString(num++, n).toUpperCase());
        }
        
        // 튜브 순서에 맞춰 answer 추가, t 개수 만큼
        for(int i = 0; i < t; i++) {
            answer.append(total.charAt(p - 1 + (i * m)));
        }
        
        return answer.toString();
    }
}