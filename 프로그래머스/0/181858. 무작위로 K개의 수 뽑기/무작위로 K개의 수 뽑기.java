import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = {};
        
        // 입력 순서 유지
        Set<Integer> linkedSet = new LinkedHashSet<>();
        for(int num : arr) {
            linkedSet.add(num);
            if(linkedSet.size() == k) {
                break;
            }
        }
        
        answer = new int[k];
        int idx = 0;
        for(int num : linkedSet) {
            answer[idx++] = num;
        }
       
        while(idx < k) {
            answer[idx++] = -1;
        }
        
        return answer;
    }
}