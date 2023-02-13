import java.util.*;

class Solution {
    
    // 공백이나 숫자, 특수문자 제외 후 글자 쌍만 있는 list 반환
    public ArrayList<String> matchesToList(String str){
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < str.length() - 1; i++){
            String s1 = String.valueOf(str.charAt(i));
            String s2 = String.valueOf(str.charAt(i + 1));

            if(s1.matches("[a-zA-Z]") && s2.matches("[a-zA-Z]")){
                sb.append(s1.toUpperCase().trim()).append(s2.toUpperCase().trim());
                list.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }

        return list;
    }
    
    public int solution(String str1, String str2) {
        int answer = 0;
        
        /*
            1. 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다
                -> matches 사용
            2. 대문자와 소문자의 차이는 무시
                -> 대문자로 변환
            3. 교/합집합이 되는 List사용
                -> retainAll, addAll 사용했지만 실패
                -> for문으로 구현
        */
        
        ArrayList<String> list1;
        ArrayList<String> list2;

        list1 = matchesToList(str1);
        list2 = matchesToList(str2);
        
        // 정렬
        Collections.sort(list1);
        Collections.sort(list2);
        
        // 교/합집합
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();

        // 교집합
        for(String s : list1) {
            // 집합1에 집합2가 포함된다면 삭제후, 교집합에 추가
            if(list2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }

        // 합집합
        // 교집합에서 제외된 것 뺀 나머지 합집합에 추가
        for(String s : list2) {
            union.add(s);
        }

        // 공집합일 경우
        if(intersection.size() == 0 && union.size() == 0){
            return 65536;
        }
        
        answer = (int)((double) intersection.size() / union.size() * 65536);
        
        return answer;
    }
}