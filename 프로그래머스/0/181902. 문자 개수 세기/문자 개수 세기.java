class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for(char c : my_string.toCharArray()) {
            
            if(c >= 'A' && c <= 'Z') {
                // 대문자
                answer[c - 'A']++;
            
            } else if(c >= 'a' && c <= 'z') {
                // 소문자
                answer[c - 'a' + 26]++;
            }
        }
        
        return answer;
    }
}