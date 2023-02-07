import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 내림차순 정렬을 위해 Integer배열로 변경
        Integer[] arr = new Integer[citations.length];
        for(int i = 0; i < citations.length; i++){
            arr[i] = citations[i];
        }
        
        // 내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());
        
        for(int i = 0; i < arr.length; i++){
            // 피인용 수가 논문 수보다 더 작아지기 시작하는 직전의 수가 h이다 (유튜브 인용구)
            // 다시 말하면 h = 논문 수가 피인용 수와 같거나 커질때의 수
            // if문 = 같거나 커질 때 answer++ 해줌
            if(arr[i] >= i + 1){ // 논문 수 => i + 1 -> 배열 0부터 시작이라 1부터
                answer++;
            }
        }
        
        // 정렬
        // Arrays.sort(citations);
        
        // for(int i = 0; i < citations.length; i++){
        //     if(citations[i] >= citations.length - i){
        //         answer = citations.length - i;
        //         break;
        //     }
        // }
        
        return answer;
    }
}