import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        
        if((array.length < 1 && array.length > 100) || (n < 1 && n > 100)){
            return -1;
        }
        
        Arrays.sort(array);
        
        for(int i = 0; i < array.length; i++){
            int a = Math.abs((array[i] - n));
            
            if(min > a){
                min = a;
                answer = array[i];
            }
        }
        
        return answer;
    }
}