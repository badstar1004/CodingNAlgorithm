class Solution {
    public int[] solution(int[] numbers) {
        
        if(numbers == null || (numbers.length <= 0 || numbers.length > 1000)){
            return null;
        }
        
        int[] answer = {};
        
        answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            
            if(numbers[i] < -10000 && numbers[i] > 10000){
                return null;
            }
            
            answer[i] = numbers[i] * 2;
        }
        
        return answer;
    }
}