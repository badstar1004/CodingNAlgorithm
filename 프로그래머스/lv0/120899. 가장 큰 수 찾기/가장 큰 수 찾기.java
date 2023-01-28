import java.util.*;

class Solution {
    public int[] solution(int[] array) {
        int[] answer = {};
        
        if(array.length < 1 && array.length > 100){
            return null;
        }
        
        for(Integer item : array){
            if(item < 0 && item > 1000){
                return null;
            }
        }
        
        int[] array2 =  array.clone();
        
        answer = new int[2];
        Arrays.sort(array);
        
        answer[0] = array[array.length - 1];
        
        for(int i = 0; i < array2.length; i++){
            if(answer[0] == array2[i]){
                answer[1] = i;
            }
        }
        
        return answer;
    }
}