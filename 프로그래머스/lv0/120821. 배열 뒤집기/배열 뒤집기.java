import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        
        // 제한사항
        if((num_list == null) || ((num_list.length < 1) && (num_list.length > 1000))){
            return null;
        }
        
        int[] answer = new int[num_list.length];
        List<Integer> intList = new ArrayList<>();
        
        // 변환
        for (int element : num_list) {
            intList.add(element);
        }
        
        Collections.reverse(intList);
        
        answer = intList.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}