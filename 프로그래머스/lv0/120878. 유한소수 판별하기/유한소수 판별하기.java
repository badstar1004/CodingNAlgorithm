class Solution {
    public int gcd(int a, int b){
        if(a % b == 0){
            return b;
        }
        
        return gcd(b, a % b);
    }
    
    public int solution(int a, int b) {
        int answer = 0;
        
        int newB = b / gcd(a, b);
        
        // 약분
        while(newB != 1){
            if(newB % 2 == 0){
                newB /= 2;
            } else if(newB % 5 == 0){
                newB /= 5;
            } else {
                // 나누어 떨어지지 않는다면
                return 2;
            }
        }
        
        // 나누어 떨어지면
        return 1;
    }
}