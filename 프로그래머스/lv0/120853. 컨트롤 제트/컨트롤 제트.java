class Solution {
    public int solution(String s) {
        int answer = 0;
        
        if(s.length() < 1 && s.length() > 200){
            return -1;
        }
        
        String[] str = s.split(" ");
        
        for(int i = 0; i < str.length; i++){
            if(str[i].equals("Z")){
                answer -= Integer.parseInt(str[i - 1]);
            } else {
                answer += Integer.parseInt(str[i]);
            }
        }
        
        return answer;
    }
}