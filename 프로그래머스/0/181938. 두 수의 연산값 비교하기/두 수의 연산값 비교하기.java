class Solution {
    public int solution(int a, int b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(b);
        
        int append = Integer.parseInt(sb.toString());
        int multi = 2 * a * b;
        
        return append > multi ? append : (append == multi ? append : multi);
    }
}