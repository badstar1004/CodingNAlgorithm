public class Solution {
    private int[] answer = {-1};
    private int maxDiff = Integer.MIN_VALUE;

    public int[] solution(int n, int[] info) {
        dfs(n, info, new int[11], 0);
        return answer;
    }

    private void dfs(int arrow, int[] apeach, int[] lion, int idx) {
        // return 값
        if (idx == 11) {
            // 비교 계산
            int diff = calDiff(apeach, lion);
            if (diff > 0 && (diff > maxDiff || (diff == maxDiff && isBetter(lion)))) {
                maxDiff = diff;
                answer = lion.clone();
            }
            return;
        }

        // 라이언이 해당 점수에 화살을 쏘지 않는 경우
        dfs(arrow, apeach, lion, idx + 1);
        
        
        if (arrow > apeach[idx]) {
            lion[idx] = apeach[idx] + 1;
            dfs(arrow - lion[idx], apeach, lion, idx + 1);
            lion[idx] = 0;
        }
        
        if (idx == 10 && arrow > 0) {
            lion[idx] += arrow;
            dfs(0, apeach, lion, idx + 1);
            lion[idx] = 0;
        }
    }
    
    // 비교 계산
    private int calDiff(int[] apeach, int[] lion) {
        int apeachSum = 0, lionSum = 0;
        for (int i = 0; i < 11; i++) {
            // apeach == lion
            if (apeach[i] == 0 && lion[i] == 0) {
                continue;
            }

            // apeach >= lion
            if (apeach[i] >= lion[i]) {
                apeachSum += (10 - i);

            } else {
                lionSum += (10 - i);
            }
        }
        return lionSum - apeachSum;
    }
    
    
    private boolean isBetter(int[] lion) {
        for (int i = 10; i >= 0; i--) {
            if (answer[i] < lion[i]) {
                return true;
            }
            
            if (answer[i] > lion[i]) {
                return false;
            }
        }
        return false;
    }
}