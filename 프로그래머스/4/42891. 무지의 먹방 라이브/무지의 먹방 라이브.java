import java.util.*;

class Solution {
    
    // Food 클래스 생성
    class Food {
        int time;
        int index;
        
        Food(int time, int index) {
            this.time = time;
            this.index = index;
        }
    }
    
    public int solution(int[] food_times, long k) {
        // 모든 음식 시간
        long totalFoodTime = 0;
        for(int time : food_times) {
            totalFoodTime += time;
        }
        
        // k가 총 음식 시간보다 크다면 -1 (더 섭취해야 할 음식이 없다면)
        if(totalFoodTime <= k) {
            return -1;
        }
        
        // 우선순위 큐 (오름차순)
        PriorityQueue<Food> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        for(int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }
        
        // 먹는 데 걸린 시간
        long eatTime = 0;
        // 이전 단계까지 먹은 시간
        long preEatTime = 0;
        // 남은 음식 수
        long length = food_times.length;
        
        // 음식을 다 먹기 전 k가 되는 지 확인
        while(eatTime + ((pq.peek().time - preEatTime) * length) <= k) {
            int culTime = pq.poll().time;
            eatTime += (culTime - preEatTime) * length;
            length -= 1;
            preEatTime = culTime;
        }
        
        // 남은 음식들 처리
        List<Food> foodList = new ArrayList<>();
        while(!pq.isEmpty()) {
            foodList.add(pq.poll());
        }
        
        foodList.sort((a, b) -> a.index - b.index);
        
        // k 만큼 이동한 위치 음식 return
        return foodList.get((int) ((k - eatTime) % length)).index;
    }
}