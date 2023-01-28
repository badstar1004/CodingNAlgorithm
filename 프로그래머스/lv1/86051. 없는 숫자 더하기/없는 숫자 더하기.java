import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = -1;
        
        if(numbers.length < 1 && numbers.length > 9){
            return -1;
        }
        
        return IntStream.range(0, 10).filter(i -> Arrays.stream(numbers).noneMatch(num -> i == num)).sum();
    }
}