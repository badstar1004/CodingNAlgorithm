import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 최소값
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        
        // 최대값
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation : operations) {
            // 잘라서 배열을 만듦
            String[] parts = operation.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);
            
            // 삽입 연산 일 경우
            if (command.equals("I")) {
                minQueue.offer(number);
                maxQueue.offer(number);
                
            } else if (command.equals("D")) {
                
                if(minQueue.isEmpty()) {
                    continue;
                }
                
                // 최대값 삭제
                if (number == 1) {
                    int maxValue = maxQueue.poll();
                    
                    // 최소값에서도 값 제거
                    minQueue.remove(maxValue);
                    
                } else if (number == -1) {
                    // 최소값 삭제
                    int minValue = minQueue.poll();
                    // 최대값에서도 값 제거
                    maxQueue.remove(minValue);
                }
            }
        }
        
        if(minQueue.isEmpty()) {
            return new int[] {0, 0};
            
        } else {
            return new int[] {maxQueue.peek(), minQueue.peek()};
        }
    }
}