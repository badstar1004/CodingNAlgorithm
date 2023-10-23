import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(isCheck(s, i)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static boolean isCheck(String s, int rotationIndex) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt((i + rotationIndex) % s.length());
            
            if (stack.isEmpty()) {
                stack.push(c);
                
            } else {
                switch(c) {
                    case ')':
                        if(stack.peek() == '(') stack.pop();
                        else stack.push(c);
                        break;
                    case ']':
                        if(stack.peek() == '[') stack.pop();
                        else stack.push(c);
                        break;
                    case '}':
                        if(stack.peek() == '{') stack.pop();
                        else stack.push(c);
                        break;
                    default:
                        stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }
}