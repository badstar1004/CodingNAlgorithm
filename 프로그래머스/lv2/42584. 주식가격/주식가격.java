class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        
        /*
            1. 배열 원소 기준으로 가격이 몇초동안 안떨어지는지 구하는 문제
            2. 이중 for문
        */
        
        answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                answer[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        
        return answer;
    }
}