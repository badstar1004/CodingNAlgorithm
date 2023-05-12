import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 10진수로 변환할 수
        String N = st.nextToken();
        // 진법
        int B = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 0; i < N.length(); i++) {
            char digit = N.charAt(i);
            ans *= B;

            if('0' <= digit && digit <= '9'){
                ans += digit - '0';

            } else {
                ans += 10 + digit - 'A';
            }
        }

        System.out.println(ans);
    }
}