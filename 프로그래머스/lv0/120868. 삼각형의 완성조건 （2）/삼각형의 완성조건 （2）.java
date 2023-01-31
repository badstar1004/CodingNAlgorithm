class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        // 배열 안에서 가장 긴 변 구하기
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        
        for(int i = 1; i <= max; i++){
            if(min + i > max){
                answer++;
            }
        }
        
        // 나머지 한 변이 가장 긴 경우
        for(int i = max + 1; i < (max + min); i++){
            answer++;
        }
        
        return answer;
    }
}