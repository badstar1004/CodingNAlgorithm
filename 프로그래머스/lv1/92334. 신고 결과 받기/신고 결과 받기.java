import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];   

        HashMap<String, Integer> user_id = new HashMap<>();
        HashMap<String, HashSet<String>> user_report = new HashMap<>();

        for(int i = 0; i < id_list.length; i++) {
            user_id.put(id_list[i], i);                     
            user_report.put(id_list[i], new HashSet<>());  
        }
        
        for(String item : report) {
            String[] str = item.split(" ");  
            user_report.get(str[1]).add(str[0]);     
        }
        
        for(int i = 0; i < id_list.length; i++) {
            HashSet<String> hashSet = user_report.get(id_list[i]);

            if(hashSet.size() >= k) {
                for(String s : hashSet) {
                    answer[user_id.get(s)]++;
                }
            }
        }
        
        return answer;
    }
}