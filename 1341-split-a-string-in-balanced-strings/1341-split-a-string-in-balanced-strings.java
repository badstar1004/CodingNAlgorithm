class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int numCnt = 0;

        for(char c : s.toCharArray()) {
            if(c == 'R') {
                numCnt++;
            } else if(c == 'L') {
                numCnt--;
            }

            if(numCnt == 0) {
                count++;
            }
        }

        return count;
    }
}