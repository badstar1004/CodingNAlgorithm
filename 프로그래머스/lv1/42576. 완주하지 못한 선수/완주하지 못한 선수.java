import java.util.*;
import java.util.Map.*;

class Solution {
    public String solution(String[] participant, String[] completion) {

        String answer = "";
        
        // HashMap
        HashMap<String, Integer> map = new HashMap<>();
        
        // 선수 명단
        for (String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }

        // 완주자
        for (String comp : completion) {
            map.put(comp, map.get(comp) - 1);
        }

        // 결과
        for(Map.Entry<String, Integer> result : map.entrySet()) {
            if(result.getValue() > 0) {
                answer = result.getKey();
                break;
            }
        }
        
        return answer;
    }
}