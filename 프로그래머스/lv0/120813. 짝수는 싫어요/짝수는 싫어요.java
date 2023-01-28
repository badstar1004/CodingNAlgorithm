class Solution {
    public int[] solution(int n) {
        
        int[] answer = new int[(n - 1) / 2 + 1];
        
        // 제한사항
        if(n < 1 && n > 100){
            return null;
        }
        
        for(int i = 1; i <= n; i += 2){
            answer[i / 2] = i;
        }
        
        return answer;
    }
}