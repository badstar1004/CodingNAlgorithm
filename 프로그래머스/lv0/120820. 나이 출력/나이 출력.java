class Solution {
    public int solution(int age) {
        int answer = 0;
        
        // 제한사항
        if((age <= 0) && (age > 120)){
            return -1;
        }
        
        answer = 2022 - age + 1;
        
        return answer;
    }
}