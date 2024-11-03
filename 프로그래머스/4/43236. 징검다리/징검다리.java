import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        
        // 정렬
        Arrays.sort(rocks);
        
        // distance가 1이상이라 최소는
        int left = 1;
        int right = distance;
        int answer = 0;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int removeCount = 0;
            int pre = 0;
            
            for(int rock : rocks) {
                if(rock - pre < mid) {
                    removeCount++;
                    
                } else {
                    pre = rock;
                }
            }
            
            // 마지막 거리
            if(distance - pre < mid) {
                removeCount++;
            }
            
            if(removeCount <= n) {
                answer = mid;
                left = mid + 1;
                
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
}