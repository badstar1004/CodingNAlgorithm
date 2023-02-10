import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {-1};
        
        // 정렬
        Arrays.sort(arr);
        
        // List
        List<Integer> list = new ArrayList<>();
        
        // for문
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
               list.add(arr[i]); 
            }
        }
        
        if(list.size() > 0){
            answer = new int[list.size()];
                             
            int idx = 0;
            for(int n : list){
                answer[idx++] = n;
            }
        }
        
        return answer;
    }
}