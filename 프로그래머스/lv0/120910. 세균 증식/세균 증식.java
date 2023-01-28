class Solution {
    public int solution(int n, int t) {
        int answer = 0;
        
        if((n < 1 && n > 10) || (t < 1 && t > 15)){
            return -1;
        }
        
        answer = n;
        
        for(int i = 1; i < t + 1; i++){
            answer *= 2;
        }
        
        return answer;
    }
}