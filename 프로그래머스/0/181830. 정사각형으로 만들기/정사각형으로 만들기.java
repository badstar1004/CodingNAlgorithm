import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer = {};
        
        int rows = arr.length;
        int cols = arr[0].length;
        
        if (rows > cols) {
            // 각 행의 끝에 0을 추가
            int[][] result = new int[rows][rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = arr[i][j];
                }
            }
            
            return result;
            
        } else if (cols > rows) {
            
            // 새로운 행을 추가
            int[][] result = new int[cols][cols];
            for (int i = 0; i < rows; i++) {
                result[i] = Arrays.copyOf(arr[i], cols);
            }
            
            for (int i = rows; i < cols; i++) {
                Arrays.fill(result[i], 0);
            }
            
            return result;
        } else {
            
            // 행과 열의 수가 같으면 그대로 반환
            return arr;
        }
    }
}
