import java.io.*;
import java.util.*;

public class Main {

    private static long[] convertBase(long x, int B){
        int len = 0;
        long copyX = x;
        while (copyX > 0){
            copyX /= B;
            len++;
        }

        long[] digit = new long[len];
        len = 0;
        while (x > 0){
            digit[len++] = (long)x % B;
            x /= B;
        }

        return digit;
    }

    private static boolean isPalindrome(long[] digit) {
        for (int i = 0; i < digit.length / 2; i++) {
            if(digit[i] != digit[digit.length - i - 1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            long x = Integer.parseInt(br.readLine());

            boolean ans = false;
            // 모든진법
            for (int i = 2; i <= 64; i++) {
                long[] digit = convertBase(x, i);
                if(isPalindrome(digit)){
                    ans = true;
                }
            }

            System.out.println(ans ? 1 : 0);
        }
    }
}