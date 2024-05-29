class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        // 모든 원소 곱하기, 모든 원소 합
        int totalMultiple = 1, totalSum = 0;
        for(int i = 0; i < num_list.length; i++) {
            totalMultiple *= num_list[i];
            totalSum += num_list[i];
        }
        
        totalSum = (int) (Math.pow(totalSum, 2));
        
        return totalMultiple > totalSum ? 0 : 1;
    }
}