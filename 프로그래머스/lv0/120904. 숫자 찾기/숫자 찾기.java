class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        
        // indexOf()
        String strNum = String.valueOf(num);
        String strK = String.valueOf(k);
        
        answer = strNum.indexOf(strK);
        
        return answer < 0 ? -1 : answer + 1;
    }
}