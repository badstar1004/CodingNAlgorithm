class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        while (true) {
            boolean[][] remove = new boolean[m][n];
            
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char current = map[i][j];
                    
                    if (current != '0'
                           && current == map[i][j + 1]
                           && current == map[i + 1][j]
                           && current == map[i + 1][j + 1]) {
                        remove[i][j] = remove[i][j + 1] = remove[i + 1][j] = remove[i + 1][j + 1] = true;
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (remove[i][j]) {
                        count++;
                        map[i][j] = '0';
                    }
                }
            }

            // 지워진 블록이 없으면 종료
            if (count == 0) {
                break;
                
            } else {
                answer += count;
            }

            // 블록 떨어뜨리기
            for (int j = 0; j < n; j++) {
                int index = m - 1;
                
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != '0') {
                        char temp = map[i][j];
                        map[i][j] = '0';
                        map[index][j] = temp;
                        index--;
                    }
                }
            }
        }
        
        return answer;
    }
}