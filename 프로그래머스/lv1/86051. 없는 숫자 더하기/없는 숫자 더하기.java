import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] exist = new boolean[10];  // 초기값은 false

        // numbers에 있는 숫자들 true로 수정
        for (int num : numbers) {
            if (num < 10) {
                exist[num] = true;
            }
        }
        
        // false 인 요소들만 더함
        for(int i = 0; i < 10; i++) {
            if(!exist[i]) {
                answer += i;
            }
        }
        
        return answer;
        
        // Stream 사용
        // return IntStream.range(0, 10)
        //     .filter(i -> Arrays.stream(numbers).noneMatch(num -> i == num)).sum();
    }
}