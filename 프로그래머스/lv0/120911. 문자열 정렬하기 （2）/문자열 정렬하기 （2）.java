import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        // toLowerCase(), toCharArray()
        my_string = my_string.toLowerCase();
        
        char[] tmpArray = my_string.toCharArray();
        
        Arrays.sort(tmpArray);
        
        String newString = new String(tmpArray);
        
        return newString;
    }
}