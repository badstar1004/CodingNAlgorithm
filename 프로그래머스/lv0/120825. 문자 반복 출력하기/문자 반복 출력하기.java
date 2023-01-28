class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        
        // 제한사항
        if((my_string.length() < 2) && (my_string.length() > 5)
          ||(n < 2) && (n <10)){
            return "";
        }
        
        // StringBuilder 객체 선언
        StringBuilder sb = new StringBuilder();
        
        for(char c : my_string.toCharArray()){
            sb.append((c + "").repeat(n));
        }
        
        return sb.toString();
    }
}