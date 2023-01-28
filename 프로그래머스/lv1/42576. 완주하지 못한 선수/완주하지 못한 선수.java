import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public String solution(String[] participant, String[] completion) {

        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for (String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }

        for (String comp : completion) {
            map.put(comp, map.get(comp) - 1);
        }

        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}