class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        
        if((array.length < 1 && array.length > 100) || (n < 0 && n > 1000)){
            return -1;
        }
        
        for(int item : array){
            if(n == item){
                answer++;
            }
        }
        
        return answer;
    }
}