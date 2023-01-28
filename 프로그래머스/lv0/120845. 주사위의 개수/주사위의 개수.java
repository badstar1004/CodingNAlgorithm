class Solution {
    public int solution(int[] box, int n) {
        int answer = 0;
        
        if((box.length < 3 && box.length > 3) && (n < 1 && n > 50)){
            return -1;
        }
        
        answer = (box[0] / n) * (box[1] / n) * (box[2] / n);
        
        return answer;
    }
}