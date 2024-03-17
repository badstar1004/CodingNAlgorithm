class Solution {
    public int solution(String word) {
        int answer = 0;
        
        // 5의 거듭제곱
        int[] weight = {781, 156, 31, 6, 1};    // 각 자리수의 거듭제곱 (= 가중치)
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        
        for(int i = 0; i < word.length(); i++) {
            for(int j = 0; j < vowels.length; j++) {
                if(word.charAt(i) == vowels[j]) {
                    answer += 1 + j * weight[i];
                    break;
                }
            }
        }
        
        return answer;
    }
}