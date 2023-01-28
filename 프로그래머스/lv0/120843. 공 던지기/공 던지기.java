class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        
        if((numbers.length <= 2 && numbers.length >= 100)
         && (k <= 0 && k >=1000)){
            return -1;
        }
        
        answer = numbers[2 * (k - 1) % numbers.length];
        
        return answer;
    }
}