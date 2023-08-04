class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length;
        
        int evenCnt = 0;
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            int num = nums[i];
            
            while(num > 0) {
                num /= 10;
                cnt++;
            }
            
            if(cnt % 2 == 0) {
                evenCnt++;
            }
        }
        
        return evenCnt;
    }
}