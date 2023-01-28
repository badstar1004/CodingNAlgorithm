class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxWidth = 0;
        int maxheight = 0;
        
        for(int[] item : sizes){
            maxWidth = Math.max(maxWidth, Math.max(item[0], item[1]));
            maxheight = Math.max(maxheight, Math.min(item[0], item[1]));
        }
        
        return maxWidth * maxheight;
    }
}