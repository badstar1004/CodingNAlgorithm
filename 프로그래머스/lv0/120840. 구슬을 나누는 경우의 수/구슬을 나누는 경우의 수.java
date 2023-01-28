import java.math.*;

class Solution {
    
    public BigInteger factorial(int a){
        if(a == 1){
            return BigInteger.ONE;
        }

        BigInteger b = BigInteger.ONE;

        for (int i = a; i > 0; i--) {
            b = b.multiply(BigInteger.valueOf(i));
        }

        return b;
    }
    
    public int solution(int balls, int share) {
        BigInteger answer;
        
        if((balls < 1 && balls > 30) && (share < 1 && share > 30) && share > balls){
            return -1;
        }
        
        answer = factorial(balls).divide(factorial((balls - share)).multiply(factorial(share)));
        
        return answer.intValue();
    }
}