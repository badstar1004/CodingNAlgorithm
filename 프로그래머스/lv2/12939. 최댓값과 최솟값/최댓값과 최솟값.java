import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        // 문자열 배열 생성 (공백 기준으로 자름)
        String[] str = s.split(" ");
        // 리스트 생성
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < str.length; i++) {
            list.add(Integer.parseInt(str[i]));
        }
        
        // Collections.min / max 사용
        sb.append(Collections.min(list)).append(" ").append(Collections.max(list));
        
        return sb.toString();
    }
}