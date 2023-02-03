import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        
        // List 사용
        List<Integer> list = new ArrayList<>();

        // List에 옮겨 담아줌
        for (int num : numlist) {
            list.add(num);
        }

        // 정렬 (거리의 차(절대값)으로 비교)
        list.sort((a, b) -> {
            int diffA = Math.abs(a - n);
            int diffB = Math.abs(b - n);
            if (diffA != diffB) {
                return diffA - diffB;
            } else {
                // 거리가 같으면 큰 수가 앞으로
                return b - a;
            }
        });

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}