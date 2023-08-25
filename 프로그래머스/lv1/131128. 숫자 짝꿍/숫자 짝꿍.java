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
        
        
        if(sb.length() == 0) {
            return "-1";
            
        } else if (sb.charAt(0) == '0') {
            return "0";
            
        } else {
            return sb.toString();
        }
        
    }
}