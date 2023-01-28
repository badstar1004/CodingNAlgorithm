import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        int[] answer = {};
        
        if(my_string.length() < 1 && my_string.length() > 100){
            return null;
        }
        
        my_string = my_string.replaceAll("[^0-9]", "");

        answer = new int[my_string.length()];

        for(int i = 0; i < my_string.length(); i++){
            answer[i] = (my_string.charAt(i) - '0');
        }

        Arrays.sort(answer);
        
        return answer;
    }
}