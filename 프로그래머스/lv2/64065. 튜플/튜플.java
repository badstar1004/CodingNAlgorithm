import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        /* HashMap으로 구현
            중복된 횟수가 많은 것부터 answer배열에 저장
        */
        
        // HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        // 문자열 '{' / '}' 없앤 후 ',' 기준으로 배열 생성
        String[] str =  s.replaceAll("[{ | }]", "").split(",");
        
        // HashMap에 저장
        for(String c : str){
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        
        // 정렬을 위해 hashMap.entrySet() 을 리스트(Map.Entry<>)로 변환
        List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());

        // 정렬 (값 기준 내림차순)
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        // answer 배열에 저장
        answer = new int[list.size()];
        int i = 0;
        for(Map.Entry<String, Integer> key : list){
            answer[i++] = Integer.parseInt(key.getKey());
        }
        
        return answer;
    }
}