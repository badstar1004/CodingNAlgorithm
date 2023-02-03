class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // while 문
        int cnt = 0;
        while(cnt < n){
            answer++;
            
            // 3의 배수이거나 3이 있을때까지
            while(answer % 3 == 0 || String.valueOf(answer).contains("3")){
                answer++;
            }
            
            cnt++;
        }

        return answer;
    }
}