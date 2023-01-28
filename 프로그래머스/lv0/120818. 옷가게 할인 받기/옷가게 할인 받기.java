class Solution {
    public int solution(int price) {
        int answer = 0;
        
        // 제한사항
        if((price < 10) && price > 1000000){
            return -1;
        }
        
        // 할인 계산
        if((price >= 100000) && (price < 300000)) {
            answer = (int)(price - (0.05 * (double)price));
        } else if((price >= 300000) && (price < 500000)) {
            answer = (int)(price - (0.1 * (double)price));
        } else if(price >= 500000) {
            answer = (int)(price - (0.2 * (double)price));
        } else {
            answer = price;
        }
        
        return answer;
    }
}