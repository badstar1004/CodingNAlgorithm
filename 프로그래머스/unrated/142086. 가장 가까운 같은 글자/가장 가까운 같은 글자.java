class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        // 첫문자는 -1
        answer[0] = -1;
        
        for(int i = 1; i < s.length(); i++){
            int isIt = s.lastIndexOf(s.substring(i, i + 1), i - 1);
            
            if(isIt != -1){
                answer[i] = i - isIt;
            } else {
                answer[i] = isIt;
            }
        }
        
        return answer;
    }
}