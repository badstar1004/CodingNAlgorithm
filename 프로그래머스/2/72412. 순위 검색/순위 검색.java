import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        // info 담을 값
        Map<String, List<Integer>> infoHashMap = new HashMap<>();
        
        for(String infoItem : info) {
            String[] split = infoItem.split(" ");
            
            String[] language = {split[0], "-"};    // 언어
            String[] position = {split[1], "-"};    // 직군
            String[] career = {split[2], "-"};      // 경력
            String[] soulFood = {split[3], "-"};    // 소울푸드
            int score = Integer.parseInt(split[4]); // 점수
            
            // 경우의 수
            for (String lang : language) {
                for (String pos : position) {
                    for (String car : career) {
                        for (String food : soulFood) {
                            String key = lang + pos + car + food;
                            
                            List<Integer> list = infoHashMap.getOrDefault(key, new ArrayList<>());
                            list.add(score);
                            
                            infoHashMap.put(key, list);
                        }
                    }
                }
            }
        }
        
        
        // 점수 리스트 정렬 (오름차순)
        for (List<Integer> list : infoHashMap.values()) {
            list.sort(null);
        }
        
        // System.out.println("infoHashMap: " + infoHashMap);
        // System.out.println("infoHashMap.size(): " + infoHashMap.size());
        
        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].replaceAll(" and ", "").split(" ");
            String key = split[0];
            int score = Integer.parseInt(split[1]);

            List<Integer> list = infoHashMap.getOrDefault(key, new ArrayList<>());
            // System.out.println("list: " + list);
            
            int start = 0;
            int end = list.size();
            while (start < end) {
                int mid = (start + end) / 2;
                
                if (list.get(mid) < score) {
                    start = mid + 1;
                    
                } else {
                    end = mid;
                }
            }
            
            answer[i] = list.size() - start;
        }
    
        return answer;
    }
}