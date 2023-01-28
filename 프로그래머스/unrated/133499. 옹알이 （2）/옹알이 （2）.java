class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String str: babbling){
            if(str.contains("ayaaya") || str.contains("yeye") || str.contains("woowoo") || str.contains("mama")) {
                continue;
            }
            
            str = str.replace("aya","1").replace("ye","1").replace("woo","1").replace("ma","1").replace("1","");
            if(str.isEmpty()){
                answer++;
            }
        }
        
        return answer;
    }
}