class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n < 0 && n > 1000000){
            return -1;
        }
        
        while(n > 0){
            answer += n % 10;
            n /= 10;
        }
        
        return answer;
    }
}