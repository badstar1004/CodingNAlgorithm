import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        // 길이
        int n = topping.length;

        // 왼쪽, 오른쪽 토핑 종류 수 추적
        Set<Integer> leftSet = new HashSet<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        // 오른쪽 초기화
        for(int t : topping) {
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
        }

        // 자르는 포인트 이동하면서 비교
        for(int i = 0; i < n - 1; i++) {
            leftSet.add(topping[i]);

            if(rightMap.get(topping[i]) == 1) {
                rightMap.remove(topping[i]);
            } else {
                rightMap.put(topping[i], rightMap.get(topping[i]) - 1);
            }

            // 반반이라면 answer 증가
            if(leftSet.size() == rightMap.size()) {
                answer++;
            }
        }

        return answer;
    }
}