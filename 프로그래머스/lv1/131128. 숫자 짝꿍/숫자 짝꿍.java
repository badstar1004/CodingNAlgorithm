class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        // 문자열 반환
        StringBuilder sb = new StringBuilder();

        // 0부터 9까지 숫자 배열
        int[] arrayX = new int[10];
        int[] arrayY = new int[10];
        
        // 자리수에 맞게 count
        for(int i = 0; i < X.length(); i++){
            arrayX[X.charAt(i) - '0']++;
        }

        for(int i = 0; i < Y.length(); i++){
            arrayY[Y.charAt(i) - '0']++;
        }
        
        // 9부터 거꾸로
        for(int i = 9; i >= 0; i--){
            // 1이상이라면
            if(arrayX[i] >= 1 && arrayY[i] >= 1){
                // 반복할 횟수 (최소값)
                int min = Math.min(arrayX[i], arrayY[i]);

                // StringBuilder에 추가
                for (int j = 0; j < min; j++) {
                    sb.append(i);
                }
            }
        }

        if(sb.length() > 0){
            // 값이 0만 있을 경우
            int zeroCnt = 0;
            for (int i = 0; i < sb.length(); i++) {
                // 0 개수
                if(sb.charAt(i) == '0'){
                    zeroCnt++;
                }
            }
            // StringBuilder 길이와 0의 개수가 같다면
            if(sb.length() == zeroCnt){
                // StringBuilder 초기화 후 0 추가
                sb.delete(0, sb.length());
                sb.append(0);
            }
        }
        
        return sb.length() == 0 ? "-1" : sb.toString();
    }
}