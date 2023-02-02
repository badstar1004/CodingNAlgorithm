class Solution {
    public int solution(int n) {
        int answer = n;
        
        // Integer.bitCount 사용
        int bitCount = Integer.bitCount(n);
        
        while(true){
            // answer 증가 시키면서 bitCount가 같은지 판별
            answer++;
            if(bitCount == Integer.bitCount(answer)){
                return answer;
            }
        }
    }
}