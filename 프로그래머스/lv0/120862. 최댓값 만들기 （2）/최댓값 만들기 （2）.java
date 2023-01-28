import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Arrays.sort(numbers);
        
        // 제일 작은 두수
        int a = (numbers[0] * numbers[1]);
        
        // 제일 큰 두수
        int b = (numbers[numbers.length - 2] * numbers[numbers.length - 1]);

        return Math.max(a, b);
    }
}