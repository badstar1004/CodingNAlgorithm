import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 배열 카운트 세기
        int[] student = new int[n];
        
        // 도난당한 학생들 인덱스 카운트 --
        for(int l : lost) {
            student[l - 1]--;
        }
        
        // 여벌이 있는 학생들 인덱스 카운트++
        for(int r : reserve) {
            student[r - 1]++;
        }
        
        for(int i = 0; i < student.length; i++) {
            if(student[i] == -1) {
                if(i > 0 && student[i - 1] == 1) {
                    student[i - 1]--;
                    student[i]++;
                    
                } else if(i < student.length - 1 && student[i + 1] == 1) {
                    student[i + 1]--;
                    student[i]++;
                }
            }
        }
        
        int answer = 0;
        for(int s : student) {
            if(s >= 0) {
                answer++;
            }
        }
        
        return answer;
    }
}