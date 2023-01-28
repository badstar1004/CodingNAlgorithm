import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        
        if(seoul.length < 1 && seoul.length > 1000){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        // indexOf 사용
        int idx = Arrays.asList(seoul).indexOf("Kim");
        
        // indexOf return
        return sb.append("김서방은 ")
                 .append(idx)
                 .append("에 있다").toString();
        
        // stream 사용 return
        // return sb.append("김서방은 ")
        //          .append(String.valueOf(Arrays.stream(seoul).collect(Collectors.toList()).indexOf("Kim")))
        //          .append("에 있다").toString();
    }
}