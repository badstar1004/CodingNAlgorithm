class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int currentNum = storey % 10; // 일의 자리 숫자
            int tenNum = (storey % 100) / 10; // 십의 자리 숫자

            if (currentNum > 5) {
                answer += (10 - currentNum);
                storey += 10;
                
            } else if (currentNum == 5) {
                if (tenNum >= 5) {
                    answer += (10 - currentNum);
                    storey += 10;
                    
                } else {
                    answer += currentNum;
                    storey -= currentNum;
                }
                
            } else {
                answer += currentNum;
                storey -= currentNum;
            }
            
            storey /= 10; // 다음 자릿수로 이동
        }
        
        return answer;
    }
}