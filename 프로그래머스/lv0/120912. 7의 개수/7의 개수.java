class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int n = 0;
        
        for(int i = 0; i < array.length; i++){
            
            while(array[i] > 0){
                n = array[i] % 10;
                
                if(n == 7){
                    answer++;
                }
                array[i] /= 10;
            }
        }
        
        return answer;
    }
}