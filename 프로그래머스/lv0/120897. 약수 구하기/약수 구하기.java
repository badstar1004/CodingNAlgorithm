import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        
        double sqrt = Math.sqrt(n);
        
        for(int i = 1; i <= sqrt; i++){
            if (n % i == 0) {
    	        if (Math.pow(i, 2) == n) {  // i * i == n
                	list.add(i);
                    
		        } else {
                	list.add(i);
                    list.add(n / i);
		        }
	        }
        }
        
        Collections.sort(list);
        
        int idx = 0;
        answer = new int[list.size()];
        for(int num : list){
            answer[idx++] = num;
        }
        
        return answer;
    }
}