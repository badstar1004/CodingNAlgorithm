class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 제한사항
        if(n <= 0 && n > 1000){
            return -1;
        }
        
        for(int i = 1; i <= n; i++){
            if(i % 2 == 0){
                answer += i;
            }
        }
        
        return answer;
    }
}