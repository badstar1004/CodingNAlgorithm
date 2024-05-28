class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        // 홀수, 짝수
        StringBuilder oddNumber = new StringBuilder();
        StringBuilder evenNumber = new StringBuilder();
        for(int i = 0; i < num_list.length; i++) {
            if(num_list[i] % 2 == 1) {
                oddNumber.append(num_list[i]);
            } else {
                evenNumber.append(num_list[i]);
            }
        }
        
        return Integer.parseInt(oddNumber.toString()) + Integer.parseInt(evenNumber.toString());
    }
}