class Solution {
    
    // 최대 공약수
    public static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
    
    
    public int solution(int[] arrayA, int[] arrayB) {
        int GCD_A = arrayA[0];
        int GCD_B = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            GCD_A = gcd(GCD_A, arrayA[i]);
            GCD_B = gcd(GCD_B, arrayB[i]);
        }

        if (GCD_A == GCD_B) return 0;
        
        int potentialA = Math.max(GCD_A, GCD_B);

        for (int i = 0; i < arrayA.length; i++) {
            if ((GCD_A > GCD_B && arrayB[i] % potentialA == 0)
                    || (GCD_B > GCD_A && arrayA[i] % potentialA == 0)) {
                return 0;
            }
        }
        
        return potentialA;
    }
}