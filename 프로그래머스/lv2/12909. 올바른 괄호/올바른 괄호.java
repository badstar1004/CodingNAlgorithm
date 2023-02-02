class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        // 개수 사용
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            }
            
            if (c == ')') {
                count--;
            }
            
            if (count < 0){
                return false;
            }
        }

        return count == 0;
    }
}