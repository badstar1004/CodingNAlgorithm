class Solution
{
    public int solution(int [][]board)
    {   
        int answer = 0;
        int row = board.length;
        int col = board[0].length;
        
        // 행이나 열이 1인 경우, 최대 크기는 1
        if (row < 2 || col < 2) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 1) {
                        return 1;
                    }
                }
            }
        }
        
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(board[i][j] == 1) {
                    // 현재 위치에서 위, 왼쪽, 왼쪽 위 (대각선) 값 비교
                    board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                    
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }

        // 정사각형 넓이
        return answer * answer;
    }
}