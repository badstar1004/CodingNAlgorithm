class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        
        if((cipher.length() < 1 && cipher.length() < 1000) || code < 1 && code > cipher.length()){
            return "";
        }
        
        String[] arr = cipher.split("");
        
        for(int i = 1; i <= arr.length; i++){
            if(i % code == 0){
                answer += arr[i - 1];
            }
        }
        
        return answer;
    }
}