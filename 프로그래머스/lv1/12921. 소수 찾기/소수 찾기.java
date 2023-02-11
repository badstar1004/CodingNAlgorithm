class Solution {
    public int solution(int n) { 
        int answer = 0; 
        boolean[] prime = new boolean [n + 1];
        
        // for
        for(int i = 2; i <= n; i++){
            prime[i] = true;
        }
      
        // for
        for(int i = 2; i <= Math.sqrt(n); i++){
            for(int j = i; (i * j) <= n; j++){
                prime[i * j] = false;
            }
        }
        
        // forEach 개수
        for(boolean bool : prime){
            if(bool){
                answer++;
            }
        }
        
        return answer; 
    }
}