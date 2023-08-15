import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        
        // HashMap
        HashMap<String, Integer> map = new HashMap<>();
        
        // name 별 그리움 점수
        for(int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        answer = new int[photo.length];
        
        // 사진별 그리움 합계
        for(int i = 0; i < photo.length; i++) {
            int sum = 0;
            
            for(String person : photo[i]) {
                sum += map.getOrDefault(person, 0);
            }
            
            answer[i] = sum;
        }
        
        return answer;
    }
}