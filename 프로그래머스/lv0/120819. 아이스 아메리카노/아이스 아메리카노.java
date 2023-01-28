class Solution {
    public int[] solution(int money) {
        int[] answer = new int[2];
        
        // 제한사항
        if((money <= 0) && (money >1000000)){
            return null;
        }
        
        // 계산
        answer[0] = (int)(money / 5500);
        answer[1] = money - (answer[0] * 5500);
        
        return answer;
    }
}