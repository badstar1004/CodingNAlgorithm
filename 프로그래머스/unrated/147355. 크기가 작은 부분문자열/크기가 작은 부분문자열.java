class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int sub = p.length() - 1;

        for(int i = 0; i < t.length() - sub; i++){
            if(Long.valueOf(t.substring(i, sub + i + 1)) <= Long.valueOf(p)){
                answer++;
            }
        }
        
        return answer;
    }
}