import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        List<String> listArr = new ArrayList<>();
        for (String s1 : s.split("")) {
            listArr.add(s1);
        }

        listArr.sort((o1, o2) -> o2.compareTo(o1));
        
        StringBuilder sb = new StringBuilder();
        
        for(String str : listArr){
            sb.append(str);
        }
        
        return sb.toString();
    }
}