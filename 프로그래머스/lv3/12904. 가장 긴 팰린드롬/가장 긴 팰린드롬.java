class Solution{
    public int solution(String s){
        int answer = 0;
        
        // 문자열 길이
        int len = s.length();
        if(len <= 1) {
            return len;
        }
        
        // 최대길이
        int maxLen = 0;
        for(int i = 0; i < len; i++) {
            // 하나의 문자만
            maxLen = Math.max(maxLen, isPalindrome(s, i, i));
            
            // 두개의 문자
            maxLen = Math.max(maxLen, isPalindrome(s, i, i + 1));
        }

        return maxLen;
    }
    
    private static int isPalindrome(String s, int left, int right) {
        int L = left, R = right;
        
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        
        return R - L - 1;
    }
}