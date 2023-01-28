class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        // 제한사항
        if((my_string.length() < 1) && (my_string.length() > 1000)){
            return "";
        }
        
        for(int i = my_string.length() - 1; i >= 0; i--){
            answer += "" + my_string.charAt(i);
        }
        
        return answer;
    }
}