class Solution {
    public String solution(int age) {
        String answer = "";
        
        int as = 97;
        if(age > 1000){
            return "";
        }
        
        String[] arrAge = Integer.toString(age).split("");
        
        for(int i = 0; i < arrAge.length; i++){
            answer += (char)(Integer.parseInt(arrAge[i]) + as);
        }
        
        return answer;
    }
}