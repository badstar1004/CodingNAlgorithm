class Solution {
    public int[] sortedSquares(int[] nums) {
        // 투 포인터
        int n = nums.length;
        
        int[] result = new int[n];
        
        int i = 0;  // 처음
        int j = n - 1;  // 끝
        for(int k = n - 1; k >= 0; k--) {
            if(Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[k] = nums[i] * nums[i];
                i++;
            } else {
                result[k] = nums[j] * nums[j];
                j--;
            }
        }
        
        return result;
    }
}