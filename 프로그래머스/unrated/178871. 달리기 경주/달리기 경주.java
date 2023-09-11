import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        // HashMap
        HashMap<String, Integer> rank = new HashMap<>();
        
        // player의 이름 인덱스
        for(int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }
        
        // callings로 인한 순위 변경
        for(String name : callings) {
            // name 인덱스
            int idx = rank.get(name);
            
            // 앞선수
            String tempName = players[idx - 1];
            
            // 순위 변경
            players[idx - 1] = name;
            players[idx] = tempName;
            
            // hashMap 순위 변경
            rank.put(players[idx - 1], idx - 1);
            rank.put(players[idx], idx);
        }
        
        
        return players;
    }
}