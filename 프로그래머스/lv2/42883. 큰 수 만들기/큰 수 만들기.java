import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        // Deque
        Deque<Character> deque = new LinkedList<>();
        
        for(int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            // System.out.println("first: " + c);
            // System.out.println("startK: " + k);
            
            while(!deque.isEmpty()
                    && k > 0 && deque.peekLast() < c) {
                deque.removeLast();
                k--;
                
                // System.out.println("deque_OUT: " + deque);
                // System.out.println("minusK: " + k);
            }
            
            deque.addLast(c);
            // System.out.println("deque_IN: " + deque);
        }
        
        // System.out.println("deque_OUT_FOR: " + deque);
        // System.out.println("k_OUT_FOR: " + k);
        
        while (k > 0) {
            deque.removeLast();
            k--;
            
        }
        
        // System.out.println("deque_RESULT: " + deque);
        
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        
        return sb.toString();
    }
}