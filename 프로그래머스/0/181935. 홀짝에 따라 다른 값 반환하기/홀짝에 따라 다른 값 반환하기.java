class Solution {
    public int solution(int n) {
        int sum = 0;
        
        if (n % 2 == 1) {
            // 홀수인 경우 홀수의 합을 구함
            for (int i = 1; i <= n; i += 2) {
                sum += i;
            }
        } else {
            // 짝수인 경우 짝수의 제곱의 합을 구함
            for (int i = 0; i <= n; i += 2) {
                sum += i * i;
            }
        }
        
        return sum;
    }
}