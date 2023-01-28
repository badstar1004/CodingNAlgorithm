import java.util.*;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        
        int[] answer = {};
        
        // 제한사항
        if((numbers.length < 2 && numbers.length > 30)
        || (num1 < 0 && num1 > 2) || (num2 <= num1 && num2 > numbers.length)){
            return null;
        }
        
        answer = Arrays.copyOfRange(numbers, num1, num2 + 1);
        
        return answer;
    }
}