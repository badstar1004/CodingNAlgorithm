class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        
        // 문자열로 만듦
        String str = "" + n;
        
        // 문자열 길이 만큼의 int형 배열
        answer = new int[str.length()];
        
        // 배열 인덱스 선언
        int idx = 0;
        
        // 자리수 단위로 계산
        while(n > 0){
            answer[idx++] = (int)(n % 10);
            n /= 10;
        }
        
        return answer;
    }
}