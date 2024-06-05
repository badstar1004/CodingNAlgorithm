class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 시전 시간
        int t = bandage[0];
        // 초당 회복량
        int recoveryAmount = bandage[1];
        // 추가 회복량
        int addRecoveryAmount = bandage[2];
        
        int maxHealth = health;
        int curHealth = health;
        int continuousSuccessTime = 0;
        int attackIndex = 0;
        
        for(int time = 1; time <= attacks[attacks.length - 1][0]; time++) {
            if(attackIndex < attacks.length
              && time == attacks[attackIndex][0]) {
                int damage = attacks[attackIndex][1];
                // 공격 받음
                curHealth -= damage;
                
                // 연속 성공 시간 초기화
                continuousSuccessTime = 0;
                
                attackIndex++;
                    
            } else {
                if(continuousSuccessTime < t) {
                    // 공격이 없는 시간에 회복
                    continuousSuccessTime++;
                    curHealth = Math.min(maxHealth, curHealth + recoveryAmount);
                }
                
                if(continuousSuccessTime == t) {
                    curHealth = Math.min(maxHealth, curHealth + addRecoveryAmount);
                    continuousSuccessTime = 0;
                }
                
            }
            
            // 체력 0이하 체크
            if(curHealth <= 0) {
                return -1;
            }
        }
        
        
        return curHealth;
    }
}