class Solution {
    public int[] solution(int[] num_list) {
        
        int[] answer = new int[2];
        
        // 제한사항
        if((num_list.length < 1) && (num_list.length > 100)){
            return null;
        }
        
        for(int num: num_list){
            
            // 제한사항
            if((num < 0) && (num > 1000)){
                return null;
            }
            
            answer[num % 2]++;
        }
        
        return answer;
    }
}