class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int num = 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 오른쪽
            for (int j = colStart; j <= colEnd; j++) {
                answer[rowStart][j] = num++;
            }
            rowStart++;

            // 아래
            for (int i = rowStart; i <= rowEnd; i++) {
                answer[i][colEnd] = num++;
            }
            colEnd--;

            if (rowStart <= rowEnd) {
                // 왼쪽
                for (int j = colEnd; j >= colStart; j--) {
                    answer[rowEnd][j] = num++;
                }
            }
            rowEnd--;

            if (colStart <= colEnd) {
                // 위
                for (int i = rowEnd; i >= rowStart; i--) {
                    answer[i][colStart] = num++;
                }
            }
            colStart++;
            
        }
        
        return answer;
    }
}