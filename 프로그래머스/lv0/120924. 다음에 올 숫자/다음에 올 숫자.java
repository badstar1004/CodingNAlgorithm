class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        // 첫번째 수와 두번째 수 등차/등비
        int arithmetic = common[1] - common[0];     // 등차수열
        answer = common[common.length - 1];         // 마지막 값
        
        // 두번째 수와 세번째 수 등차이면
        if(arithmetic == common[2] - common[1]){
            answer += arithmetic;
            // 두번째 수와 세번째 수 등비이면
        } else {
            int geometric = common[2] / common[1];      // 등비수열
            answer *= geometric;
        }
        
        return answer;
    }
}