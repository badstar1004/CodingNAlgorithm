import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Arrays.sort(numbers);
        
        Stack<Integer> stack = new Stack();
        
        for(int a : numbers){
            stack.push(a);
        }
        
        int a = stack.pop();
        int b = stack.pop();
        
        answer = a * b;
        
        return answer;
    }
}