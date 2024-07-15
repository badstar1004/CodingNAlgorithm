import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = {};
        
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        
        while(i < arr.length) {
            if(stack.isEmpty()) {
                // stack.isEmpty() ? arr[i] 추가 i++
                stack.push(arr[i]);
                i++;
                
            } else if(stack.peek() < arr[i]) {
                // 마지막 원소 < arr[i] ? arr[i] 추가 i++
                stack.push(arr[i]);
                i++;
                
            } else {
                // 마지막 원소 >= arr[i] ? 마지막 원소 제거
                stack.pop();
            }
        }
        
        stk = new int[stack.size()];
        for(int j = stack.size() - 1; j >= 0; j--) {
            stk[j] = stack.pop();
        }
        
        return stk;
    }
}