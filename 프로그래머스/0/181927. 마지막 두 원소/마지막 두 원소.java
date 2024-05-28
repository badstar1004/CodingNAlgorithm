class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];
        
        for(int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[i];
        }
        
        int lastNum = num_list[num_list.length - 1];
        int prvLastNum = num_list[num_list.length - 2];
        
        
        if(lastNum > prvLastNum) {
            answer[answer.length - 1] = lastNum - prvLastNum;
        } else {
            answer[answer.length - 1] = lastNum * 2;
        }
        
        return answer;
    }
}