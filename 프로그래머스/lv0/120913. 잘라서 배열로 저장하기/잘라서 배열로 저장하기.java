import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = {};
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i < my_str.length(); i += n) {
            if(i + n < my_str.length()){
                list.add(my_str.substring(i, i + n));
                
            } else {
                list.add(my_str.substring(i, my_str.length()));
            }
        }
        
        answer = new String[list.size()];
        
        int idx = 0;
        for(String s : list){
            answer[idx++] = s;
        }
        
        return answer;
    }
}