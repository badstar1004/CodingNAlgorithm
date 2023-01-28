class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        
        if((array.length < 1 && array.length > 100) || (height < 1 && height > 200)){
            return -1;
        }
        
        for(int n : array){
            if(height < n){
                answer++;
            }
        }
        
        return answer;
    }
}