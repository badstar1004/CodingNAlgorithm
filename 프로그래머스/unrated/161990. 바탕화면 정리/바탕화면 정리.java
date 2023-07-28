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
        int top = Integer.MAX_VALUE;        // 위 (최소)
        int left = Integer.MAX_VALUE;       // 왼쪽 (최소)
        int right = Integer.MIN_VALUE;      // 오른쪽 (최대)
        int bottom = Integer.MIN_VALUE;     // 아래 (최대)
        
        // 2중 for문
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < cor; j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    top = Math.min(top, i);
                    left = Math.min(left, j);
                    right = Math.max(right, i);
                    bottom = Math.max(bottom, j);
                }
            }
        }
        
        return new int[]{top, left, right + 1, bottom + 1};
        
    }
}