import java.util.*;

class Solution {
    static class Pair {
        int idx;
        int priority;

        Pair(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
    
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 큐와 우선순위 큐
        Queue<Pair> normalQueue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        // 데이터 넣기
        for (int i = 0; i < priorities.length; i++) {
            normalQueue.add(new Pair(i, priorities[i]));
            priorityQueue.add(priorities[i]);
        }
        
        while(!normalQueue.isEmpty()) {
            Pair cur = normalQueue.poll();
            
            // 현재 프로세스의 우선순위가 최고 우선순위와 같은 경우
            if (cur.priority == priorityQueue.peek()) {
                priorityQueue.poll();
                answer++;

                if (cur.idx == location) {
                    break;
                }
                
            } else {
                normalQueue.add(cur);
            }
        }
        
        
        return answer;
    }
}