class Solution {
    
    // 최대공약수
    public int gcd(int a, int b) {
    
        if(a % b == 0) {
            return b;
        }
    
        return gcd(b, a % b);
    }
    
    public int solution(int n) {
        int answer = 0;
        
        // 제한사항
        if(n < 0 && n > 100){
            return -1;
        }
        
        // 최소공배수
        answer = n * 6 / gcd(n, 6);
        
        return answer / 6;
    }
}