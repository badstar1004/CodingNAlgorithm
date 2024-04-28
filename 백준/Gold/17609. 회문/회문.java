import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 T
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String input = br.readLine();
            System.out.println(classifyString(input));
        }
    }

    private static int classifyString(String input) {
        // 문자열 길이
        int n = input.length();
        int left = 0, right = n - 1;

        while (left < right) {
            // 양쪽 비교
            if(input.charAt(left) != input.charAt(right)) {
                if(isPalindrome(input, left + 1, right) || isPalindrome(input, left, right - 1)) {
                    return 1;
                } else {
                    return 2;
                }
            }

            left++;
            right--;
        }

        return 0;
    }

    private static boolean isPalindrome(String input, int left, int right) {
        while (left < right) {
            if(input.charAt(left) != input.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}