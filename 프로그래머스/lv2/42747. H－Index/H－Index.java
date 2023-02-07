import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // 내림차순 정렬을 위해 Integer배열로 변경
        Integer[] arr = new Integer[citations.length];
        
        for(int i = 0; i < citations.length; i++){
            arr[i] = citations[i];
        }
        
        // 내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= i + 1){
                answer++;
            }
        }
        
        // 정렬
        // Arrays.sort(citations);
        
        // for(int i = 0; i < citations.length; i++){
        //     if(citations[i] >= citations.length - i){
        //         answer = citations.length - i;
        //         break;
        //     }
        // }
        
        return answer;
    }
}