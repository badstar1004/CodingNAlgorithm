import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        // 스택
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < numbers.length; i++) {
            // 앞쪽값과 뒤쪽값 확인
            while (!stack.isEmpty()
                    && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            
            stack.push(i);
        }
        
        // 큰값이 존재하지 않는 경우
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}