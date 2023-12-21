import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();

        int count0 = 0, count1 = 0;

        // 첫번째
        if(s.charAt(0) == '0') {
            count0++;
        } else {
            count1++;
        }

        for(int i = 0; i < len - 1; i++) {
            if(s.charAt(i) != s.charAt(i + 1)) {
                if(s.charAt(i + 1) == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}