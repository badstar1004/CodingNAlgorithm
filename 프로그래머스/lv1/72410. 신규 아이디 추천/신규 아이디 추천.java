import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        StringBuilder sb = new StringBuilder();
        // StringBuilder
        // 1단계 & 2단계
        for (char c : new_id.toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)
                        || c == '-' || c == '_' || c == '.') {
                sb.append(Character.toLowerCase(c));
            }
        }
        
        // 3단계
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == '.' && sb.charAt(i - 1) == '.') {
                sb.deleteCharAt(i);
                i--;
            }
        }
        
        // 4단계
        if (sb.length() > 0 && sb.charAt(0) == '.') {   // 처음
            sb.deleteCharAt(0);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') { // 끝
            sb.deleteCharAt(sb.length() - 1);
        } 
        
        // 5단계
        if(sb.length() == 0) {
            sb.append('a');
        }
        
        // 6단계
        if(sb.length() >= 16) {
            sb.delete(15, sb.length());
            
            if(sb.charAt(sb.length() - 1) == '.') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        
        // 7단계
        while(sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        
        
        return sb.toString();
        
        
//         // 정규식
//         String answer = new_id.toLowerCase()    // 1단계
//             .replaceAll("[^-_.a-z0-9]", "")     // 2단계
//             .replaceAll("[.]{2,}", ".")         // 3단계
//             .replaceAll("^[.]|[.]$", "");       // 4단계
        
//         if(answer.equals("")) {                 // 5단계
//             answer += "a";    
//         }
        
//         if(answer.length() >= 16) {             // 6단계
//             answer = answer.substring(0, 15);
//             answer = answer.replaceAll("[.]$", "");
//         }
        
//         while(answer.length() <= 2) {           // 7단계
//             answer += answer.charAt(answer.length() - 1);
//         }
        
        // return answer;
    }
}