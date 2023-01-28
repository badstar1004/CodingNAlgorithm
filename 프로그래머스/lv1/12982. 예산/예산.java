import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int result = 0;
        
        if(budget < 1 && budget > 10000000){
            return -1;
        }
        
        Arrays.sort(d);
        
        for(int i = 0; i < d.length; i++){
            budget -= d[i];
            
            if(budget < 0){
                break;
            }
            answer++;
            
            // result += d[i];
            // if(result > budget){
            //     answer = i;
            //     break;
            // }
        }
        
        // if(result <= budget){
        //     answer = d.length;
        // }
        
        return answer;
    }
}