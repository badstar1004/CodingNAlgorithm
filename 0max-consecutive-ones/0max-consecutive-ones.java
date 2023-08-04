class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxNum = 0;
        int num = 0;
        
        for(int n : nums) {
            if(n == 1) {
                num++;
                
                if (num > maxNum) {
                    maxNum = num;
                }
            } else {
                num = 0;
            }
        }
        
        return maxNum;
    }
}