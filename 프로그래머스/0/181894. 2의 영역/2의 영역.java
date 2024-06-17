class Solution {
    public int[] solution(int[] arr) {
        
        int n = arr.length;
        int start = -1;
        int end = -1;
        
        for(int i = 0; i < n; i++) {
            if(arr[i] == 2) {
                // 시작과 끝 2로 맞춤
                if(start == -1) {
                    start = i;
                }
                
                end = i;
            }
        }
        
        if(start == -1) {
            return new int[] {-1};
        }
        
        int[] result = new int[end - start + 1];
        for(int i = start; i <= end; i++) {
            result[i - start] = arr[i];
        }
        
        return result;
    }
}