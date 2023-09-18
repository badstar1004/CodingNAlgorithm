class Solution {
    
    private static boolean isPrime(long number) {
        if(number <= 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    private static String convertBinary(int n, int k) {
        StringBuilder str = new StringBuilder();
 
        while (n > 0) {
            str.append(n % k);
            n /= k;
        }
 
        // str = str.reverse();
        return str.reverse().toString();
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        
        // 변환
        String convert = convertBinary(n, k);
        
        // split
        String[] split = convert.split("0");
        for (String x : split) {
            if (x.equals("")) {
                continue;
            }
            
            if (isPrime(Long.parseLong(x))) {
                answer++;
            }
        }
        
        return answer;
    }
}