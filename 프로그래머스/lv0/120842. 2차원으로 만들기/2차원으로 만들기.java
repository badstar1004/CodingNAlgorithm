class Solution {
    public int[][] solution(int[] num_list, int n) {
        
        if((num_list.length % n != 0) && (num_list.length < 0 && num_list.length > 150)
         && (n < 2 && n > num_list.length)){
            return null;
        }
        
        int[][] answer = new int[num_list.length / n][n];
        
        int idx = 0;
        
        for(int i = 0; i < num_list.length / n; i++){
            for(int j = 0; j < n; j++){
                answer[i][j] = num_list[idx++];
            }   
        }
        
        return answer;
    }
}