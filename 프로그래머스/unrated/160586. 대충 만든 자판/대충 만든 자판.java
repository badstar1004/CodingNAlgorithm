import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = {};
        
        // keymap
        // HashMap에 최소 횟수 저장
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(String str : keymap) {
            for(int i = 0; i < str.length(); i++) {
                char key = str.charAt(i);
                hashMap.put(key, Math.min(i + 1, hashMap.getOrDefault(key, Integer.MAX_VALUE)));
            }
        }
        
        // targets
        answer = new int[targets.length];
        for(int i = 0; i < targets.length; i++) {
            String target = targets[i];
            
            // 카운트
            int count = 0;
            for(char c : target.toCharArray()) {
                // hashMap 에 문자 Key가 없다면
                if(!hashMap.containsKey(c)) {
                    count = -1;
                    break;
                }
                
                // 카운트에 key에 대한 value값 더함
                count += hashMap.get(c);
            }
            
            answer[i] = count;
        }        
        
        return answer;
    }
}