class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        if(my_string.length() < 1 && my_string.length() > 1000){
            return "";
        }
        
        char[] c = my_string.toCharArray();
        
        for(char cs : c){
            if(Character.isLowerCase(cs)){
                answer += Character.toUpperCase(cs);
            } else {
                answer += Character.toLowerCase(cs);
            }
        }
        
        return answer;
    }
}