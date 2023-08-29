import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < enemy.length; i++) {
            if (n >= enemy[i]) { // 현재 병사로 이번 라운드의 적을 막을 수 있다면
                n -= enemy[i];
                answer++;
                pq.offer(enemy[i]); // 우선순위 큐에 추가
                
            } else if (k > 0 && !pq.isEmpty() && pq.peek() > enemy[i]) { 
                // 무적권을 사용할 수 있고, 이전 라운드에서 막았던 적이 현재 라운드의 적보다 더 많다면
                n += pq.poll() - enemy[i]; // 가장 큰 적의 수와 현재 라운드의 적의 수의 차만큼 병사 수 조정
                answer++;
                k--; // 무적권 사용
                pq.offer(enemy[i]); // 우선순위 큐에 추가
                
            } else if (k > 0) {
                k--; // 무적권 사용
                answer++;
                
            } else {
                break;
            }
        }
        
        return answer;
    }
}