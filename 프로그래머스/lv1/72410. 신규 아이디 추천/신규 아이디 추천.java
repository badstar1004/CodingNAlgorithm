class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase()    // 1단계
            .replaceAll("[^-_.a-z0-9]", "")     // 2단계
            .replaceAll("[.]{2,}", ".")         // 3단계
            .replaceAll("^[.]|[.]$", "");       // 4단계
        
        if(answer.equals("")) {                 // 5단계
            answer += "a";    
        }
        
        if(answer.length() >= 16) {             // 6단계
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        
        while(answer.length() <= 2) {
            answer += answer.charAt(answer.length() - 1);
        }
        
        return answer;
    }
}