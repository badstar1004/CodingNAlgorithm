class Solution {
    public int facto(int n){
        if(n <= 1){
            return n;
        }
        
        return n * facto(n - 1);
    }
    
    public int solution(int n) {
        int answer = 0;
        
        if(n <= 0 && n > 3628800){
            return -1;
        }
        
        for(int i = 1; i <= n; i++){
            if(facto(i) == n){
                answer = i;
                break;
                
            } else if(facto(i) > n){
                answer = i - 1;
                break;
            }
        }
        
        return answer;
    }
}