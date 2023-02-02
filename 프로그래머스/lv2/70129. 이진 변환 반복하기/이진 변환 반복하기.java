class Solution {
    public int[] solution(String s) {
        // 길이 고정
        int[] answer = new int[2];
        int zeroRemove = 0;     // 0 카운트
        int transCnt = 0;       // 변환 카운트
        
        //while문, for문
        while(!s.equals("1")){
            
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                if(c == '1'){
                    sb.append(c);
                } else {
                    // 0 카운트
                    zeroRemove++;
                }
            }
            
            // sb 길이 이진 변환
            s = Integer.toBinaryString(sb.length());
            // 변환 카운트
            transCnt++;
        }
              
        answer[0] = transCnt;
        answer[1] = zeroRemove;     
              
        return answer;
    }
}