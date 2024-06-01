class Solution {
    public int solution(String[][] board, int h, int w) {

        int n = board.length;
        int count = 0;
        
        // 방향
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        
        
        for(int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];
            
            if(nx >= 0 && nx < n && ny >= 0 && ny < n
              && board[h][w].equals(board[nx][ny])) {
                count++;
            }
        }
        
        return count;
    }
}