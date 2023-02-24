class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        
        // a와 b가 같아지면 종료
        // while문
        while(a != b){
            a = (a / 2) + (a % 2);
            b = (b / 2) + (b % 2);
            answer++;
        }

        return answer;
    }
}