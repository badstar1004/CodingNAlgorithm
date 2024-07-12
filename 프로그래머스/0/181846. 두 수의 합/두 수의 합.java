class Solution {
    public String solution(String a, String b) {
        StringBuilder answer = new StringBuilder();
        
        // 끝 부터 더하기
        int i = a.length() - 1;
        int j = b.length() - 1;
        int div = 0;
        
        while(i >= 0 || j >= 0 || div != 0) {
            int x = (i >= 0) ? a.charAt(i) - '0' : 0;
            int y = (j >= 0) ? b.charAt(j) - '0' : 0;
            
            int sum = x + y + div;
            div = sum / 10;
            answer.append(sum % 10);
            
            i--;
            j--;
        }
        
        return answer.reverse().toString();
    }
}