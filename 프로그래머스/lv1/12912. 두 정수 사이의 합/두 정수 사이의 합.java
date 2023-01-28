import java.util.stream.*;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if(a < -10000000 && a > 10000000){
            return 0;
        }
        
        return LongStream.rangeClosed(Math.min(a, b), Math.max(a, b)).sum();
        
        
    }
}