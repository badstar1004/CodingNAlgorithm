class Solution {
    public int GCD(int a, int b){
        if(a % b == 0){
            return b;
        }
        
        return GCD(b, a % b);
    }
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        
        int bm = denom1 * denom2;
        int bj = (numer1 * denom2) + (numer2 * denom1);
        
        answer = new int[] {bj, bm};
        
        int gcd = GCD(answer[0], answer[1]);
        
        answer[0] /= gcd;
        answer[1] /= gcd;
        
        return answer;
    }
}