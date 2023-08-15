class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int matchCount = 0;
        int zeroCount = 0;
        
        for(int num : lottos) {
            if(num == 0) {
                zeroCount++;
                
            } else {
                for(int win_num : win_nums) {
                    if(num == win_num) {
                        matchCount++;
                        break;
                    }
                }
            }
        }
        
        return new int [] {getRank(zeroCount + matchCount), getRank(matchCount)};
    }
    
    public int getRank(int count) {
        switch(count) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}