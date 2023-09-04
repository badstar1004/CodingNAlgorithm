import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        // 크레인 위치
        for(int move : moves) {
            
            int col = move - 1;
            
            // 게임화면 보드
            for(int row = 0; row < board.length; row++) {
                if(board[row][col] != 0) {
                    int doll = board[row][col];
                    // 초기화
                    board[row][col] = 0;
                    
                    // 스택 데이터랑 비교
                    if(!stack.isEmpty() && doll == stack.peek()) {
                        stack.pop();
                        answer += 2;
                        
                    } else {
                        stack.push(doll);
                    }
                    
                    break;
                }
            }
        }
        
        return answer;
    }
}