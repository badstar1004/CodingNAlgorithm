import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        // Map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        // System.out.println("map: " + map);
        
        // key 기준 List
        List<Integer> list = new ArrayList<>(map.keySet());
        // 정렬 
        list.sort(((a, b) -> map.get(b) - map.get(a)));
        // System.out.println("list: " + list);
        
        int i = 0;
        while(k > 0) {
            k -= map.get(list.get(i));
            answer++;
            i++;
        }
        
        return answer;
    }
}