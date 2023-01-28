class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        if(hp < 0 && hp > 1000){
            return -1;
        }
        
        answer = (hp / 5) + ((hp % 5) / 3) + ((hp % 5) % 3);
        
        return answer;
    }
}