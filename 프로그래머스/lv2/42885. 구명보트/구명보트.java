import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(people);

        // 최소 기준점
        int min = 0;
        for(int i = people.length - 1; i >= 0; i--){    // 거꾸로 (최소값 + 최대값)
            // 기준점이 i를 넘기면 break
            if(min > i){
               break;
            }
            
            // 최대값 + 최소값 limit 넘지않는 범위
            if(people[i] + people[min] <= limit){
                // 최소값 증가
                min++;
            }
            
            // 보트 수
            answer++;
        }
        
        return answer;
    }
}