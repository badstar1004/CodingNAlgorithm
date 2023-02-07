import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 짝수 길이면 0
        if(citations.length % 2 == 0){
            return answer;
        }
        
        // 오름차순 정렬
        Arrays.sort(citations);
        
        while(answer + 1 <= citations[answer]){
            answer++;
        }
        
        return answer;
    }
}