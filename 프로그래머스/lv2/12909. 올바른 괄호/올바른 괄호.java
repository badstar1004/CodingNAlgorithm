import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        // 개수 사용
//         int count = 0;

//         for (char c : s.toCharArray()) {
//             if (c == '(') {
//                 count++;
//             }
            
//             if (c == ')') {
//                 count--;
//             }
            
//             if (count < 0){
//                 return false;
//             }
//         }

        // return count == 0;
        
        // 문제대로 stack 사용
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // ( 괄호면 넣기
                stack.push(c);
                
            } else {     // ) 괄호면 스택이 비어있는지 확인 후 빼기
                if(stack.isEmpty()){
                    return false;
                }
                
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}