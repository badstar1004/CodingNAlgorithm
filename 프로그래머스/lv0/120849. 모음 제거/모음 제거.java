class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        if((my_string.length() < 1 && my_string.length() > 1000)){
            return "";
        }
        
        answer = my_string.replaceAll("[aeiou]", "");
        
        return answer;
    }
}