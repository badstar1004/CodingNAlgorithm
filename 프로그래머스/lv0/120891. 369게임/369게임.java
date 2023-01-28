class Solution {
    public int solution(int order) {
        int answer = 0;
        
        if(order < 1 && order > 1000000){
            return -1;
        }
        
        while(order > 0) {
            int a = order % 10;
            
            if((a != 0) && (a % 3 == 0)){
                answer++;
            }
            
            order /= 10;
        }
        
        return answer;
    }
}