import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        boolean isMatch = true;
        
        if(before.length() != after.length()){
            return 0;
        }
        
        List<String> list1 = Arrays.asList(before.split(""));
        List<String> list2 = Arrays.asList(after.split(""));
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        for(int i = 0; i < list1.size(); i++){
            if(!list1.get(i).equals(list2.get(i))){
                isMatch = false;
                break;
            }
        }
        
        return isMatch ? 1 : 0;
    }
}