import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        /*
            1. 유형별 점수를 계산
            2. for문, StringBuilder
        */
        
        // 유형별 점수
        HashMap<Character, Integer> kindMap = new HashMap<>();
        kindMap.put('R', 0);
        kindMap.put('T', 0);
        kindMap.put('C', 0);
        kindMap.put('F', 0);
        kindMap.put('M', 0);
        kindMap.put('J', 0);
        kindMap.put('A', 0);
        kindMap.put('N', 0);
        
        // 선택지별 점수
        HashMap<Integer, Integer> choiceMap  = new HashMap<>();
        choiceMap.put(1, 3);
        choiceMap.put(2, 2);
        choiceMap.put(3, 1);
        choiceMap.put(4, 0);
        choiceMap.put(5, 1);
        choiceMap.put(6, 2);
        choiceMap.put(7, 3);
        
        // 유형 계산
        for(int i = 0; i < survey.length; i++) {
            char one = survey[i].charAt(0);
            char two = survey[i].charAt(1);
            
            int score = choiceMap.get(choices[i]);
            if (choices[i] <= 4) {
                kindMap.put(one, kindMap.get(one) + score);
                
            } else {
                kindMap.put(two, kindMap.get(two) + score);
            }
        }
        
        StringBuilder result = new StringBuilder();
        result.append(kindMap.get('R') >= kindMap.get('T') ? 'R' : 'T');
        result.append(kindMap.get('C') >= kindMap.get('F') ? 'C' : 'F');
        result.append(kindMap.get('J') >= kindMap.get('M') ? 'J' : 'M');
        result.append(kindMap.get('A') >= kindMap.get('N') ? 'A' : 'N');
        
        return result.toString();
    }
}