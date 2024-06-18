class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        // 쿼리 처리
        for(int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            
            // 초기화
            int minValue = Integer.MAX_VALUE;
            boolean found = false;
            
            // k 보다 큰값 찾기
            for (int j = s; j <= e; j++) {
                if (arr[j] > k && arr[j] < minValue) {
                    minValue = arr[j];
                    found = true;
                }
            }
            
            // 결과 저장
            if (found) {
                answer[i] = minValue;
                
            } else {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}