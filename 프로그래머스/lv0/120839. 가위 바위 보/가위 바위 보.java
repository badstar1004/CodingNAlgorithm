class Solution {
    public String solution(String rsp) {
        String answer = "";
        
        if(rsp.length() <= 0 && rsp.length() > 100){
            return "";
        }
        
        String[] str = rsp.split("");
        
        for(String s : str){
            if(s.equals("2")){
                answer += "0";
            } else if(s.equals("0")){
                answer += "5";
            } else{
                answer += "2";
            }
        }
        
        return answer;
    }
}