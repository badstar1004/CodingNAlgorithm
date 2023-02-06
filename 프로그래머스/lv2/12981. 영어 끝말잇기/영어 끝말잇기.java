import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        // HashSet 사용
        HashSet<String> set = new HashSet<>();
        
        // 첫번째 단어 (단어 비교)
        set.add(words[0]);
        
        // for문
        for(int i = 1; i < words.length; i++){
            
            // 마지막 글자 != 첫 글자 || 이전 단어가 있는 경우
            if(words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)
             || set.contains(words[i])){
                // answer에 넣기
                answer[0] = i % n + 1; // 사람 번호
                answer[1] = i / n + 1; // 몇 번째 차례
                break;
                
            } else {
                // set에 넣기
                set.add(words[i]);
            }
        }

        return answer;
    }
}