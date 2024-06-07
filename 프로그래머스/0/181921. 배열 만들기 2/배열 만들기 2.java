import java.util.*;


class Solution {
    public int[] solution(int l, int r) {
        int[] answer = {};
        
        List<Integer> validNumberList = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("5");
        
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            
            if(!cur.isEmpty()) {
                long num = Long.parseLong(cur);
                if(num >= l && num <= r) {
                    validNumberList.add((int) num);
                }
                
                if(num > r) {
                    continue;
                }
            }
            
            if(cur.length() < 7) {
                queue.add(cur + "0");
                queue.add(cur + "5");
            }
        }
        
        if(validNumberList.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(validNumberList);
        return validNumberList.stream().mapToInt(i -> i).toArray();
    }
}