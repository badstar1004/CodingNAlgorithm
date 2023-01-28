import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        
        if((nums.length < 1 && nums.length > 10000)){
            return 0;
        }
        
        HashSet<Integer> hs = new HashSet();
        
        for(int item : nums){
            hs.add(item);
        }
        
        return (answer > hs.size() ? hs.size() : answer);
    }
}