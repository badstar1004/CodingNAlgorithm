class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
 
        int slope1 = (dots[0][1] - dots[1][1]) * (dots[2][0] - dots[3][0]);
        int slope2 = (dots[2][1] - dots[3][1]) * (dots[0][0] - dots[1][0]);
        if(slope1 == slope2) return 1;

        int slope3 = (dots[0][1] - dots[2][1]) * (dots[1][0] - dots[3][0]);
        int slope4 = (dots[1][1] - dots[3][1]) * (dots[0][0] - dots[2][0]);
        if(slope3 == slope4) return 1;

        int slope5 = (dots[0][1] - dots[3][1]) * (dots[2][0] - dots[1][0]);
        int slope6 = (dots[2][1] - dots[1][1]) * (dots[0][0] - dots[3][0]);
        if(slope5 == slope6) return 1;

        return answer;
    }
}