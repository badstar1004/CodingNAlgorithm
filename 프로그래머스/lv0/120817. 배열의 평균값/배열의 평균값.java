class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        double sum = 0;
        
        // 제한사항
        if(numbers == null || (numbers.length < 1 && numbers.length > 100)){
            return -1;
        }
        
        for(int num : numbers){
            answer += num;
        }
        
        answer /= (double)numbers.length;
        
        return answer;
    }
}