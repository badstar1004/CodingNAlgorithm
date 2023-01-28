class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        if(phone_number.length() < 4 && phone_number.length() > 20){
            return "";
        }
        
        // 정규식 사용
        answer = phone_number.replaceAll(".(?=.{4})", "*");
        
        return answer;
    }
}