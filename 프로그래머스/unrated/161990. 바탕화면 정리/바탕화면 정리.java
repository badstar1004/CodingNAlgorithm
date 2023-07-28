class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        
        /*
            for문
                최소, 최대로 찾기
        */
        
        int row = wallpaper.length;
        int cor = wallpaper[0].length();
        
        // 직사각형 초기화
        int minX = 0;       // 위 ()
        int minY = 0;       // 왼쪽
        int maxX = cor;     // 오른쪽
        int maxY = row;     // 아래
        
        // 2중 for문
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < cor; j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    minX = Math.max(minX, j);
                    minY = Math.max(minY, i);
                    maxX = Math.min(maxX, j);
                    maxY = Math.min(maxY, i);
                }
            }
        }
        
        return new int[]{maxY, maxX, minY + 1, minX + 1};
        
    }
}