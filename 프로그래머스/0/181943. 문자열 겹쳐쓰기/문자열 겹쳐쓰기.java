class Solution {
    public String solution(String my_string, String overwrite_string, int s) {

        StringBuilder sb = new StringBuilder(my_string);
        // setCharAt() -> 특정 인덱스의 문자를 변경
        for(int i = 0; i < overwrite_string.length(); i++) {
            sb.setCharAt(s + i, overwrite_string.charAt(i));
        }
        
        return sb.toString();
    }
}