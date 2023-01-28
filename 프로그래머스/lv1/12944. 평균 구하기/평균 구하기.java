import java.util.*;
import java.util.stream.*;

class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        
        answer = Arrays.stream(arr).average().getAsDouble();
        
        // for(int i = 0; i < arr.length; i++){
        //     answer += arr[i];
        // }
        
        return answer;
        // return answer / arr.length;
    }
}