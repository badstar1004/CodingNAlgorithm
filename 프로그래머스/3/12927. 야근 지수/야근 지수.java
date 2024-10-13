import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        // 최대 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // 작업량 추가
        for(int work : works) {
            maxHeap.add(work);
        }
        
        // N시간 동안 야근 ➡️ 작업량 감소
        while(n > 0) {
            if(maxHeap.isEmpty()) {
                break;
            }
            
            // 큰 작업량 꺼냄
            int maxWork = maxHeap.poll();
            if(maxWork > 0) {
                // 작업량 줄임
                maxWork--;
                // 다시 작업량 추가
                maxHeap.add(maxWork);
            }
            
            // 시간 줄임
            n--;
        }
        
        // 남은 작업량들 제곱의 합
        long answer = 0;
        while(!maxHeap.isEmpty()) {
            int work = maxHeap.poll();
            answer += work * work;
        }
        
        return answer;
    }
}