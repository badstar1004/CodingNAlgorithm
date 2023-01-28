import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        // compare() 재정의
        Arrays.sort(strings,
                   (a, b) -> {
                                if(a.charAt(n) > b.charAt(n)){
                                    return 1;
                                } else if(a.charAt(n) < b.charAt(n)){
                                    return -1;
                                }
                       
                                return a.compareTo(b);
                             });
        
        return strings;
    }
}