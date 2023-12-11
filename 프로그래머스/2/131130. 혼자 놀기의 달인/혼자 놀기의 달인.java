import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        // 방문여부
        boolean[] visited = new boolean[cards.length];
        
        // 첫번째, 두번째 그룹
        int maxGroupSize1 = 0, maxGroupSize2 = 0;
        
        for(int i = 0; i < cards.length; i++) {
            if(!visited[i]) {
                int count = 0;
                int curIdx = i;
                
                while(!visited[curIdx]) {
                    visited[curIdx] = true;
                    // -1 => 1부터 시작해서 인덱스 조절
                    curIdx = cards[curIdx] - 1;
                    count++;
                }
                
                // 두 개의 가장 큰 그룹 크기를 업데이트
                if (count > maxGroupSize1) {
                    maxGroupSize2 = maxGroupSize1;
                    maxGroupSize1 = count;
                    
                } else if (count > maxGroupSize2) {
                    maxGroupSize2 = count;
                }
            }
        }
        
        return maxGroupSize1 * maxGroupSize2;
    }
}