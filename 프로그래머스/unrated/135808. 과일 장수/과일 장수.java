import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        /*
            1. 정렬
            2. for문 (마지막부터 거꾸로)
                m의 배수면 계산
                    answer += (score[i] * m)
        */
        
        Arrays.sort(score);
        
        for(int i = score.length - 1; i >= 0 ; i--){
            if((score.length - i) % m == 0){
                answer += (score[i] * m);
            }
        }
        
        return answer;
    }
}