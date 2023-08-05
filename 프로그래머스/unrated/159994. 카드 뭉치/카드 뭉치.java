import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        // Queue
        Queue<String> qCards1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> qCards2 = new LinkedList<>(Arrays.asList(cards2));
        Queue<String> qGoal = new LinkedList<>(Arrays.asList(goal));
        
        while(!qGoal.isEmpty()) {
            String strGoal = qGoal.peek();
            
            if(!qCards1.isEmpty() && strGoal.equals(qCards1.peek())) {
                qCards1.poll();
                qGoal.poll();
                
            } else if(!qCards2.isEmpty() && strGoal.equals(qCards2.peek())) {
                qCards2.poll();
                qGoal.poll();
                
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}