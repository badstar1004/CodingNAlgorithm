import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : scoville) {
            pq.add(n);
        }
        
        // 섞어야 하는 최소 카운트
        int minCount = 0;
        while(pq.peek() < K) {
            
            // 음식의 개수가 1개 이하라면 return -1
            if(pq.size() <= 1) {
                return -1;
            }
            
            // 제일 낮은 스코빌 지수 꺼냄
            int lowFirstScovilleIndex = pq.poll();
            
            // 두번째로 낮은 스코빌 지수 꺼냄
            int lowSecondScovilleIndex = pq.poll();
            
            // 새로운 스코빌 지수 계산
            int newScovilleIndex = lowFirstScovilleIndex + (lowSecondScovilleIndex * 2);
            
            // 우선순위 큐 추가
            pq.add(newScovilleIndex);
            
            // 카운트 ++
            minCount++;
        }
        
        return minCount;
    }
}