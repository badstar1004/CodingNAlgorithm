import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        HashMap<Integer, Double> hashmap = new HashMap<Integer, Double>();
        
        // 최대 스테이지 수
        for(int i = 1; i <= N; i++){
            int stage_Challenger = 0;    // 스테이지 도전자
            int stage_NoCleared = 0;     // 스테이지 클리어 X
            double failure_Rate = 0;     // 실패율
            
            // 스테이지 뽑음
            int stage = i;
            
            // 도전자들의 스테이지
            for(int j = 0; j < stages.length; j++){
                // stage 도전자 - 해당 스테이지와 같거나 큰 수
                if(stage <= stages[j]){
                    stage_Challenger++;
                }
            
                // stage 클리어 X - 해당 스테이지와 같은 수
                if(stage == stages[j]){
                    stage_NoCleared++;
                }
            }
            
            // 실패율 계산
            if(stage_Challenger != 0 && stage_NoCleared != 0){
                failure_Rate = (double)stage_NoCleared / (double)stage_Challenger;
            }
            
            // hashMap
            hashmap.put(stage, failure_Rate);
        }
        
        answer = new int[hashmap.size()];

        for (int i = 0; i < answer.length; i++) {
            double max = Integer.MIN_VALUE;
            int maxKey = 0;

            for (int result : hashmap.keySet()) {
                if(max < hashmap.get(result)){
                    max = hashmap.get(result);
                    maxKey = result;
                }
            }

            answer[i] = maxKey;
            hashmap.remove(maxKey);
        }
        
        return answer;
    }
}