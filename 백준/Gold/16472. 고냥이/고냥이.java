import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 최대 개수
        int N = Integer.parseInt(br.readLine());

        // 문자열
        String line = br.readLine();

        // 최대 길이
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;

        for(int right = 0; right < line.length(); right++) {
            char ch = line.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > N) {
                char leftChar = line.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}