class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n < 1 && n > 1000000){
            return -1;
        }
        
        return (n % Math.sqrt(n) == 0 ? 1 : 2);
    }
}