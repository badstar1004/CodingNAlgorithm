import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
         List<Integer> selected = new ArrayList<>();
        
        for (int i = 1; i <= rank.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                if (rank[j] == i && attendance[j]) {
                    selected.add(j);
                    if (selected.size() == 3) {
                        break;
                    }
                }
            }
            
            if (selected.size() == 3) {
                break;
            }
        }
        
        
        int result = 10000 * selected.get(0) + 100 * selected.get(1) + selected.get(2);
        return result;
    }
}