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
            
            int diff = lionSum - apeachSum;
            if (diff > 0 && (diff > maxDiff || (diff == maxDiff && isBetter(lion)))) {
                maxDiff = diff;
                answer = lion.clone();
            }
            return;
        }

        if (arrow > apeach[idx]) {
            lion[idx] = apeach[idx] + 1;
            
            dfs(arrow - lion[idx], apeach, lion, idx + 1);
            lion[idx] = 0;
        }
        
        dfs(arrow, apeach, lion, idx + 1);
        if (idx == 10 && arrow > 0) {
            lion[idx] += arrow;
            dfs(0, apeach, lion, idx + 1);
            lion[idx] = 0;
        }
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