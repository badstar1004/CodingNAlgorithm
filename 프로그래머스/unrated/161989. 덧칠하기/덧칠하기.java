class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        /*
            for문
                칠할 수 있는 최대값을 찾는다.
        */
        
        // 칠할 수 있는 최대값 (Coloring + m - 1 = Coloring + m을 해줘도 무방)
        int maxColoring = 0;
        for(int Coloring : section){
            if(maxColoring <= Coloring){
                maxColoring = Coloring + m;
                answer++;
            }
        }
        
        return answer;
    }
}