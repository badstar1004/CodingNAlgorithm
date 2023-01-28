import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        
        int[] answer = new int[emergency.length];
        
        if(emergency.length < 1 && emergency.length > 10){
            return null;
        }
        
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        
        // HashMap1 에 원 순서 넣기
        for(int i = 0; i < emergency.length; i++){
            hashMap1.put(emergency[i], i);
        }
        
        // emergency 정렬
        Arrays.sort(emergency);
        
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        
        // HashMap2 에 정렬 순서 넣기
        for(int i = 0; i < emergency.length; i++){
            hashMap2.put(emergency[i], emergency.length - i);
        }
        
        // 출력
        for(int i = 0; i < emergency.length; i++){
            answer[hashMap1.get(emergency[i])] = hashMap2.get(emergency[i]);
        }
        
        return answer;
    }
}