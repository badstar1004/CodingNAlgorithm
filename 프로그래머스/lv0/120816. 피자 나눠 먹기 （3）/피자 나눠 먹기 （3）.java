class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        
        // 제한사항
        if((slice < 2 && slice > 10) || (n < 1 && 1 > 100)){
            return -1;
        }
        
        if(n % slice == 0){
            answer = n / slice;
        } else{
            answer = n / slice + 1;
        }
        
        
        return (n <= slice ? 1 : (n % slice == 0 ? n / slice : n / slice + 1));
        
        // return answer;
    }
}