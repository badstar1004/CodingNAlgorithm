import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        // 기준점 기준 폭탄 범위 지정 (왼 왼상 상 오른상 오 오른하 하 왼하)
        int[][] xy = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        
        // 폭탄 리스트 생성
        List<int[][]> booms = new ArrayList<>();
        
        // 폭탄이 있는 곳 찾기
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1){
                    booms.add(new int[][] {{i, j}});
                }
            }
        }

        // 폭탄 주변 폭탄으로 설정
        for (int[][] boom : booms) {
            for (int i = 0; i < boom.length; i++) {
                for (int k = 0; k < 8; k++) {
                    int xboom = boom[i][0] + xy[k][0];
                    int yboom = boom[i][1] + xy[k][1];
                    if((0 <= xboom && xboom < board.length) && (0 <= yboom && yboom < board.length)){
                        board[xboom][yboom] = 1;
                    }
                }
            }
        }
        
        // 폭탄 없는 곳 세기
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] != 1){
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
}