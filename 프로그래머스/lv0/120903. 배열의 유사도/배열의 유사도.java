class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        if((s1.length < 1 && s1.length > 100) || (s2.length < 1 && s2.length > 100)){
            return -1;
        }
        
        for(String item1 : s1){
            for(String item2 : s2){
                if(item1.equals(item2)){
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
}