import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        // 정렬 인덱스
        HashMap<String, Integer> sortMap = new HashMap<>();
        sortMap.put("code", 0);
        sortMap.put("date", 1);
        sortMap.put("maximum", 2);
        sortMap.put("remain", 3);
        
        // 어떤 정보 기준 인덱스
        int extIdx = sortMap.get(ext);
        
        // 정보 정렬 기준 인덱스
        int sortIdx = sortMap.get(sort_by);
        
        // 필터링
        ArrayList<int[]> filteredData = new ArrayList<>();
        for(int[] row : data) {
            if(row[extIdx] < val_ext) {
                filteredData.add(row);
            }
        }
        
        // 정렬
        filteredData.sort(Comparator.comparingInt(o -> o[sortIdx]));
        
        // 출력
        answer = new int[filteredData.size()][4];
        for(int i = 0; i < filteredData.size(); i++) {
            answer[i] = filteredData.get(i);
        }
        
        return answer;
    }
}