import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < moves.length; i++){
            int move = moves[i] - 1;
            
            for(int j = 0; j < board[move].length; j++){
                if(board[j][move] != 0){
                    int gotIt = board[j][move];
                    board[j][move] = 0;
                    if(!stack.isEmpty()){
                        if(gotIt == stack.peek()){
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(gotIt);
                        }
                    } else {
                        stack.push(gotIt);
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}