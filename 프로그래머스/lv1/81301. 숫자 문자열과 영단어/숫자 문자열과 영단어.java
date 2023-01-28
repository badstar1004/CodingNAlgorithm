class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] stringNums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < stringNums.length; i++) {
            s = s.replaceAll(stringNums[i], String.valueOf(i));
        }
        
        return Integer.parseInt(s);
    }
}