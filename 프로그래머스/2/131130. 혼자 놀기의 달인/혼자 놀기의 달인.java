import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        // 방문여부
        boolean[] visited = new boolean[cards.length];
        // 그룹
        ArrayList<Integer> group = new ArrayList<>();
        
        for(int i = 0; i < cards.length; i++) {
            if(!visited[i]) {
                int count = 0;
                int curIdx = i;
                
                while(!visited[curIdx]) {
                    visited[curIdx] = true;
                    curIdx = cards[curIdx] - 1;
                    count++;
                }
                
                group.add(count);
            }
        }
        
        // 정렬
        Collections.sort(group, Collections.reverseOrder());

        if (group.size() < 2) {
            return 0;
            
        } else {
            return group.get(0) * group.get(1);
        }
    }
}