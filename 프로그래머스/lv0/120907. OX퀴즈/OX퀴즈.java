class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        String[] split;

        // 배열 문자열 자르기
        for(int i = 0; i < quiz.length; i++){
            split = quiz[i].split(" ");
            
            // + 면
            if(split[1].equals("+")){
                if(Integer.parseInt(split[0]) + Integer.parseInt(split[2]) == Integer.parseInt(split[4])){
                    answer[i] = "O";
                    
                } else {
                    answer[i] = "X";
                }
                
                // - 면
            } else{
                if(Integer.parseInt(split[0]) - Integer.parseInt(split[2]) == Integer.parseInt(split[4])){
                    answer[i] = "O";
                    
                } else {
                    answer[i] = "X";
                }
            }
        }
        
        return answer;
    }
}