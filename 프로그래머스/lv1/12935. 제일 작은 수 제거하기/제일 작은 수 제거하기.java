import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        
        if (arr.length <= 1){
            return new int[] {-1};
        }
            
        int min = Arrays.stream(arr).min().getAsInt();
        
        return Arrays.stream(arr).filter(x -> x != min).toArray();
    }
}