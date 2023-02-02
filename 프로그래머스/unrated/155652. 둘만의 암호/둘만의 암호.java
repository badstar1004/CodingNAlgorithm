class Solution {
    public String solution(String s, String skip, int index) {
        
        // StringBuilder 생성
        StringBuilder sb = new StringBuilder();
        
        // 알파벳 선언 후 skip 제거 정규식
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        alphabet = alphabet.replaceAll("[" + skip + "]", "");
        
        // for문
        for(int i = 0; i < s.length(); i++){
            for (int j = 0; j < alphabet.length(); j++) {
                if(s.charAt(i) == alphabet.charAt(j)){
                    sb.append(alphabet.charAt((j + index) % alphabet.length()));
                    break;
                }
            }
        }
        
        return sb.toString();
        
    }
}