import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        // 존재하지 않는 경우
        if(s < n) {
            return new int[] {-1};
        }
        
        // 가능한 균등 분배가 되야함
        int base = s / n;
        int remain = s % n;
        Arrays.fill(answer, base);
        
        // 나머지 개수만큼 하나씩 추가
        for(int i = 0; i < remain; i++) {
            answer[i]++;
        }
        
        // 정렬된 배열 반환
        Arrays.sort(answer);
        
        return answer;
    }
}