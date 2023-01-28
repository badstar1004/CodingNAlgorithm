/*
    1. 수포자 1 ~ 3 찍는 방식 int[], 점수 int[] 선언
    2. for문 돌리면서 맞으면 점수++
    3. 가장 높은 점수 리턴(많으면 오름차순)
*/
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        
        // 찍는 방식
        int[] way1 = {1, 2, 3, 4, 5};
        int[] way2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] way3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 점수
        int[] score = {0, 0, 0};
        
        for(int i = 0; i < answers.length; i++){
            // 수포자1
            if(answers[i] == (way1[i % way1.length])){
                score[0]++; 
            }
            
            // 수포자2
            if(answers[i] == (way2[i % way2.length])){
                score[1]++; 
            }
            
            // 수포자3
            if(answers[i] == (way3[i % way3.length])){
                score[2]++;
            }
        }
        
        // 최대값
        int max = Math.max(Math.max(score[0], score[1]), score[2]);
        
        for (int i = 0; i < score.length; i++) {  
            if (score[i] == max) {  
                answer[i] = i + 1;  
            }  
        }  
        
        return Arrays.stream(answer).filter(i -> i != 0).toArray(); 
    }
}