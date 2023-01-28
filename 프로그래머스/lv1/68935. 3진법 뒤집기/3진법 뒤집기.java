class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuilder stringBuilder = new StringBuilder(Integer.toString(n, 3));

        stringBuilder = stringBuilder.reverse();

        answer = Integer.parseInt(stringBuilder.toString(), 3);
        
        return answer;
    }
}