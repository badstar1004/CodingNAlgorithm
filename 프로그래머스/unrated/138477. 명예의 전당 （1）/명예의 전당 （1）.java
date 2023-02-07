import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        // 점수를 넣을 ArrayList
        List<Integer> list = new ArrayList<>();
        
        // for문
        for(int i = 0; i < score.length; i++){
            // list.size() < k
            if(list.size() < k){
                list.add(score[i]);
                
            } else {
                // list.get(0) < score[i]
                if(list.get(0) < score[i]){
                    // 0번째에 넣어줌
                    list.set(0, score[i]);
                }
            }
            
            // 정렬
            Collections.sort(list);
            
            // 작은 값 부터 넣어줌
            answer[i] = list.get(0);
        }
        
        return answer;
    }
}