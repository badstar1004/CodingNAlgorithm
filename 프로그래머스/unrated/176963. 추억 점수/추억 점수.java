import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        //HashMap
        HashMap<String, Integer> mapName = new HashMap<>();
        
        for(int i = 0; i < name.length; i++){
            mapName.put(name[i], yearning[i]);
        }
        
        // 사진별 그리움 합계
        for(int i = 0; i < photo.length; i++) {
            int sum = 0;
            
            for(String p : photo[i]) {
                sum += mapName.getOrDefault(p, 0);
            }
            
            answer[i] = sum;
        }
        
        return answer;
    }
}