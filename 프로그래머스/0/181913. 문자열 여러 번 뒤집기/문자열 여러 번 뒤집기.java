class Solution {
    public String solution(String my_string, int[][] queries) {
        
        StringBuilder sb = new StringBuilder(my_string);
        for(int[] query : queries) {
            int start = query[0];
            int end = query[1];
            
            reverseSubstring(sb, start, end);
        }
        
        return sb.toString();
    }
    
    private static void reverseSubstring(StringBuilder sb, int start, int end) {
        
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            
            start++;
            end--;
        }
    }
}