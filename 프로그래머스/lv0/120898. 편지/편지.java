import java.util.*;

class Solution {
    public int solution(String message) {
        int answer = 0;
        
        if(message.length() < 1 && message.length() > 50){
            return -1;
        }
        
        char[] c = message.toCharArray();
        
        
        for(char ch : c){
            answer += 2;
        }
        
        return answer;
    }
}