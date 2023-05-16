import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static int getNumber(int T) {
        return ((T % 10) * 10) + (T / 10 + (T % 10)) % 10;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        int cur = N;
        int cnt = 0;

        do {
            cur = getNumber(cur);
            cnt++;
        } while (cur != N);

        System.out.println(cnt);
    }
}