class Solution {
    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        
        // Math.sqrt() 쓰면 포함으로
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public int solution(int[] nums) {
        int answer = 0;
        int sum = 0;
        
        // 3중 포문
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int l = j + 1; l < nums.length; l++) {
                    sum = nums[i] + nums[j] + nums[l];
                    
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;

    }
}