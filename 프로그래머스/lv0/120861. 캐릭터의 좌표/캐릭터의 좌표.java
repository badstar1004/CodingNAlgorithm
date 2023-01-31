class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int row = 0;    // 행
        int col = 0;    // 열
        int maxRow = board[0] / 2;
        int maxCol = board[1] / 2;
        
        for(int i = 0; i < keyinput.length; i++){
            if(keyinput[i].equals("up")){
                col += 1;
            } else if(keyinput[i].equals("right")){
                row += 1;
            } else if(keyinput[i].equals("down")){
                col -= 1;
            } else if(keyinput[i].equals("left")){
                row -= 1;
            }
            
            if(row >= maxRow){
                row = maxRow;
            } else if(row <= -maxRow){
                row = -maxRow;
            }

            if(col >= maxCol){
                col = maxCol;
            } else if(col <= -maxCol){
                col = -maxCol;
            }
        }
        
        answer[0] = row;
        answer[1] = col;
        
        return answer;
    }
}