import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        // HashMap
        HashMap<String, Integer> hashmap = new HashMap<>();
        
        // players 이름 인덱스 매핑
        for(int i = 0; i < players.length; i++) {
            hashmap.put(players[i], i);
        }
        
        // callings 로 순서 바꾸기
        for(String callName : callings) {
            // callName 의 인덱스 찾기
            int idx = hashmap.get(callName);
            String tempName = players[idx - 1];
            
            players[idx - 1] = players[idx];
            players[idx] = tempName;
            
            // hashMap 수정
            hashmap.put(players[idx - 1], idx - 1);
            hashmap.put(players[idx], idx);
        }
        
        
        // 시간초과
//         for(String callName : callings) {
//             for(int i = 0; i < players.length; i++) {
//                 if(callName.equals(players[i])) {
//                     String tempName = players[i];
//                     players[i] = players[i - 1];
//                     players[i - 1] = tempName;
                    
//                     break;
//                 }
//             }
//         }
        
        return players;
    }
}