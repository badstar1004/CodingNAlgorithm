import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(int[][] score) {
        // score 길이
        int n = score.length;
        // 순위 배열
        int[] res = new int[n];       
        // 평균 배열
        double[] avg = new double[n];   
        
        // HashMap 선언 (= 키를 평균으로 잡음)
        Map<Double, Integer> map = new HashMap<>();

        // 학생들의 평균
        for (int i = 0; i < n; i++) {
            avg[i] = (score[i][0] + score[i][1]) / 2.0;
        }

        // 정렬
        Arrays.sort(avg);
        
        // for문 돌면서 중복점수 x 대신 등수는 같은 등수 (HashMap function 생각하기!)
        for (int i = 0; i < n; i++) {
            map.put(avg[i], n - i);
        }

        // 학생들의 평균 점수를 기준으로 순위
        for (int i = 0; i < n; i++) {
            res[i] = map.get((score[i][0] + score[i][1]) / 2.0);
        }
        
        return res;
    }
}