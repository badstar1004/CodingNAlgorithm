import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        // Set
        Set<Integer> set = new HashSet<>();
        
        // 자릿수
        int start = 1;
        while(start <= elements.length) {
            for(int i = 0; i < elements.length; i++) {
                int sum = 0;
                
                for(int j = i; j < i + start; j++) {
                    sum += elements[j % elements.length];
                }
                
                set.add(sum);
            }
            
            start++;
        }
        
        return set.size();
    }
}