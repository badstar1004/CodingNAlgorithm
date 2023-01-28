import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] answer = {};
        
        if((n < 1 && n > 10000) || (numlist.length < 1 && numlist.length > 100)){
            return null;
        }
        
        answer = Arrays.stream(numlist).filter(x -> x % n == 0).toArray();
        
        return answer;
    }
}