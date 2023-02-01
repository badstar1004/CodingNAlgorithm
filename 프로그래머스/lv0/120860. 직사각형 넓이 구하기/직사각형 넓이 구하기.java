class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int width = 0;
        int height = 0;
        
        // x, y 기준점
        int x = dots[0][0];
        int y = dots[0][1];
        
        for(int i = 1; i < dots.length; i++){
            // 기준점과 같지 않으면
            if(x != dots[i][0]){
                // 거리 계산
                width = Math.abs(x - dots[i][0]);
            }
            
            if(y != dots[i][1]){
                height = Math.abs(y - dots[i][1]);
            }
        }
        
        return width * height;
    }
}