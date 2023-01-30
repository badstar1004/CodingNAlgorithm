class Solution {
    public int solution(String s) {
        int answer = 0;
        // 첫 문자
        int firstCnt = 0;
        // 첫 문자가 아닌 다른 글자
        int etcCnt = 0;
        
        // 첫 문자
        char c = s.charAt(0);
        
        for(int i = 0; i < s.length(); i++){
            
            // Cnt가 같아지면
            if(firstCnt == etcCnt){
                answer++;
                
                // 다시 첫 문자열 (i번째)
                c = s.charAt(i);
            }
            
            // i번째와 c와 같다면
            if(s.charAt(i) == c){
                firstCnt++;
            } else {
                etcCnt++;
            }
        }
        
        return answer;
    }
}