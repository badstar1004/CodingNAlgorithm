class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int nameLength = name.length();
        int move = name.length() - 1;     // 최대 움직일 수 있는 횟수
        
        for(int i = 0; i < name.length(); i++) {
            // 세로 조작
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            // 가로 조작
            int next = i + 1;
            // A라면 넘김
            while(next < nameLength && name.charAt(next) == 'A') {
                next++;
            }
            
            // 더 짧은 경로 선택
            move = Math.min(move, i + nameLength - next + Math.min(i, nameLength - next));
        }
        
        answer += move;
        
        return answer;
    }
}