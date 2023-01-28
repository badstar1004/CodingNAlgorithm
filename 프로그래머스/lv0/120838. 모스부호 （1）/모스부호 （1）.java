import java.util.Arrays;

class Solution {
    public String solution(String letter) {
        String answer = "";
        
        if(letter.length() < 1 && letter.length() > 1000){
            return "";
        }
        String[] letter2 = letter.split(" ");
        StringBuilder sb = new StringBuilder();
        
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---"
                        , "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-"
                        , "..-","...-",".--","-..-","-.--","--.."};
        
        for(int i = 0; i < letter2.length; i++){
            for(int j = 0; j < morse.length; j++){
                if(letter2[i].equals(morse[j])){
                    sb.append(Character.toString(j + 'a'));
                }
            }
        }
        
        answer = sb.toString();
        
        return answer;
    }
}