class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        if((str1.length() < 1 && str1.length() > 100) || (str2.length() < 1 && str2.length() > 100)){
            return -1;
        }
        
        if(str1.contains(str2)){
            answer = 1;
        } else {
            answer = 2;
        }
        
        
        return answer;
    }
}