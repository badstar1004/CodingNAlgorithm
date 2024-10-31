class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        
        int N = cookie.length;
        for(int i = 0; i < N - 1; i++) {
            int leftSum = cookie[i];
            int rightSum = cookie[i + 1];
            int left = i;
            int right = i + 1;
            
            while(right < N) {
                if(leftSum == rightSum) {
                    answer = Math.max(answer, leftSum);
                }
                
                if(leftSum <= rightSum && left > 0) {
                    left--;
                    leftSum += cookie[left];
                    
                } else if(leftSum >= rightSum && right < N - 1) {
                    right++;
                    rightSum += cookie[right];
                    
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}