// import java.util.Collections;
// import java.util.List;
// import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        // 우선순위 큐 사용
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        for(int i = 0; i < score.length; i++){
            // 넣을 때 자동으로 정렬이 됨
            priorityQueue.add(score[i]);
            
            // priorityQueue.size() > k
            if(priorityQueue.size() > k){
                // priorityQueue 에서 빼냄
                priorityQueue.poll();
            }
            
            answer[i] = priorityQueue.peek();
        }
        
//         // List 사용
//         // 점수를 넣을 ArrayList
//         List<Integer> list = new ArrayList<>();
        
//         // for문
//         for(int i = 0; i < score.length; i++){
//             // list.size() < k
//             if(list.size() < k){
//                 list.add(score[i]);
                
//             } else {
//                 // list.get(0) < score[i]
//                 if(list.get(0) < score[i]){
//                     // 0번째에 넣어줌
//                     list.set(0, score[i]);
//                 }
//             }
            
//             // 정렬
//             Collections.sort(list);
            
//             // 작은 값 부터 넣어줌
//             answer[i] = list.get(0);
//         }
        
        return answer;
    }
}