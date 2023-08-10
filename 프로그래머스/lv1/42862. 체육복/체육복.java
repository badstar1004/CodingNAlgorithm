import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 배열 카운트
        int[] student = new int[n];
        
        // 도난당한 학생들 인덱스 카운트 --
        for(int l : lost) {
            student[l - 1]--;
        }
        
        // 여벌이 있는 학생들 인덱스 카운트++
        for(int r : reserve) {
            student[r - 1]++;
        }
        
        // for문
        for(int i = 0; i < student.length; i++) {
            // 체육복을 도난 당한 학생이라면
            if(student[i] == -1) {
                
                // 앞번호 학생이 여벌의 체육복을 가지고 있는 경우 (첫번째 학생 제외)
                if(i > 0 && student[i - 1] == 1) {
                    student[i - 1]--;
                    student[i]++;
                    
                // 뒷번호 학생이 여벌의 체육복을 가지고 있는지 확인 (마지막 학생 제외)
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