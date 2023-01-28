import java.util.*;

class Solution {
    public int solution(int[] array) {
                
        int answer = 0;
        
        // 제한사항
        if(array.length % 2 == 0 || (array.length <= 0 && array.length >= 100)){
            return answer;
        }
        
        for(int number : array){
            if(number <= -1000 && number >= 1000){
                return answer;
            }
        }
        
        // 배열 정렬 후 중앙값 찾기
        Arrays.sort(array);
        answer = array[array.length / 2];

        return answer;
    }
}