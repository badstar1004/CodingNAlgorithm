class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        
        /*
            규칙 발생
            | 1 | 2 | 3 | 4 | 5 | 6 |
            |   1   |   2   |   3   |
           
            a | b
            1 | 2 가 대진을 할 경우
            a = (1 / 2) + (1 % 2) = 1;
            b = (2 / 2) + (2 % 2) = 1;
            
            a | b
            3 | 4 가 대진을 할 경우
            a = (3 / 2) + (3 % 2) = 2;
            b = (4 / 2) + (4 % 2) = 2;
            
            a 와 b가 같아 질 경우에 대진을 하게 된다.
            
        */
        // while문
        while(a != b){
            a = (a / 2) + (a % 2);
            b = (b / 2) + (b % 2);
            answer++;
        }

        return answer;
    }
}