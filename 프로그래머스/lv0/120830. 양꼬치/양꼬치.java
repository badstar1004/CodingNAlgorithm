class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        // 제한사항
        if((n <= 0 && n >= 1000) || (k < (n / 10) && k >= 1000)){
            return -1;
        }
        
        answer = (n * 12000 + k * 2000) - (n/10) * 2000;
        
        return answer;
    }
}