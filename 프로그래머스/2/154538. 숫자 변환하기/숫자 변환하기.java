import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        
        boolean[] visited = new boolean[y + 1];
        
        // 시작점
        queue.add(new int[] {x, 0});
        visited[x] = true;
        
        while(!queue.isEmpty()) {
            int[] arrCur = queue.poll();
            int curValue = arrCur[0];
            int curStep = arrCur[1];
            
            // y값에 도달한 경우
            if(curValue == y) {
                return curStep;
            }
            
            // 세 가지 연산 규칙 적용
            int[] arrNextValue = {curValue + n, curValue * 2, curValue * 3};
            
            for(int nextValue : arrNextValue) {
                if(nextValue <= y && !visited[nextValue]) {
                    visited[nextValue] = true;
                    queue.add(new int[] {nextValue, curStep + 1});
                }
            }
        }
        
        return -1;
    }
}