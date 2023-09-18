import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // Stack
        // 뒤로 빼기
        for(int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            
            String rotation = sb.substring(0, i);
            sb.delete(0, i);
            sb.append(rotation);
            
            if(isCheck(sb)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static boolean isCheck(StringBuilder sb) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            
            if (stack.isEmpty()) {
                stack.push(c);
                
            } else {
                // ()
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                
                // []
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                
                // {}
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                    
                } else {
                    stack.push(c);
                }
            }
        }
        
        if(stack.isEmpty()) {
            return true;
            
        } else {
            return false;
        }
    }
}