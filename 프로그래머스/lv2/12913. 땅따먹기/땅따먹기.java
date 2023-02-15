import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        /*
            1. DP 문제
            2. for문
                각 행마다 최대값을 더함
                    첫번째 행은 제외하고 다음 행부터 이전 행의 각 열마다 더함 (더할 열은 제외)
                        1 | 2 | 3 | 5
                        5 | 6 | 7 | 8   -> 1,0(5) 부터 시작 
                        4 | 3 | 2 | 1
                    ex) 1,0(5) 부터 시작
                        1,0(5) += 2 | 3 | 5 -> 이 중 최대값 더함
                        1,1(6) += 1 | 3 | 5 -> 이 중 최대값 더함
                        1,2(7) += 1 | 2 | 5 -> 이 중 최대값 더함
                        1,3(8) += 1 | 2 | 3 -> 이 중 최대값 더함
                3. 배열 정렬
                4. 제일 마지막자리의 값이 답
        */
        
        // for문
        for(int i = 1; i < land.length; i++){
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }
        
        // 정렬
        for(int i = 0; i < land.length; i++){
            Arrays.sort(land[i]);
        }
        
        return land[land.length - 1][3];
    }
}