class Solution {
    
    public int divisorCnt(int num){
        int cnt = 0;
        
        if(num == 0){
            return 0;
        }
        
        for(int i = 1; i * i <= num; i++){
            if(i * i == num){
                cnt++;
            } else if(num % i == 0){
                cnt += 2;
            }
        }
        
        return cnt;
    }
    
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++){
            if(divisorCnt(i) % 2 == 0){
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
}