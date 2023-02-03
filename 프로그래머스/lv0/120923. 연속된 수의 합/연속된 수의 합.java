class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        // 첫번째 값 구하기
        int start = (total / num) - (num - 1) / 2;
        
        // for문
        for(int i = 0; i < num; i++){
            answer[i] = start + i;
        }
        
        return answer;
    }
}