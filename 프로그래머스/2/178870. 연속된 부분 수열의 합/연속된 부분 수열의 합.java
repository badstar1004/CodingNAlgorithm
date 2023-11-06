class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        // 투포인터
        int start = 0, end = 0, sum = sequence[0];    // 시작, 끝, 부분 수열 합계 (start, end 0번째)
        int minLen = Integer.MAX_VALUE;     // 최소 길이
        
        while(start < sequence.length) {
            
            // 부분 수열 합계 <= k, end < sequence.length
            if(sum <= k && end < sequence.length) {
                
                // 합이 k이면 최소 길이 갱신, 인덱스 answer에 반영
                if(sum == k && (end - start + 1) < minLen) {
                    minLen = (end - start + 1);
                    answer[0] = start;
                    answer[1] = end;
                }
                
                // end 오른쪽으로 이동, 합계 업데이트
                if (++end < sequence.length) {
                    sum += sequence[end];
                }
                
            } else {
                // 합이 k보다 크면, start 오른쪽으로 이동, 합계 업데이트
                sum -= sequence[start++];
            }
        }
        
        return answer;
    }
}