class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        
        // 제한사항
        if((my_string.length() < 1) && (my_string.length() > 100)
          || (letter.length() < 1) && (letter.length() > 1)){
            return "";
        }
        
        answer = my_string.replace(letter, "");
        
        return answer;
    }
}