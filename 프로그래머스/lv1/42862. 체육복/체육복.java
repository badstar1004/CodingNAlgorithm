import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 학생 수
        int answer = n;
        
        // 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 옷이 있는 사람과 없는 사람 배열
        int[] people = new int[n];

        // lost 인 배열값 - 1 (= 배열 0번째부터 주소값, 빼줌 (기본값 0))
        for (int l : lost){
            people[l - 1]--;
        }

        // reserve 인 배열값 - 1 (= 배열 0번째부터 주소값, 더해줌 (기본값 0))
        for (int r : reserve){
            people[r - 1]++;
        }

        for (int i = 0; i < people.length; i++) {
            // 옷이 없는 사람이라면
            if(people[i] == -1) {
                // 앞에 옷이 있는 사람
                if(i - 1 >= 0 && people[i - 1] == 1) {
                    people[i]++;
                    people[i - 1]--;
                    // 뒤에 옷이 있는 사람
                } else if(i + 1 < people.length && people[i + 1] == 1) {
                    people[i]++;
                    people[i + 1]--;
                } else
                    answer--;
            }
        }
        
        return answer;
    }
}