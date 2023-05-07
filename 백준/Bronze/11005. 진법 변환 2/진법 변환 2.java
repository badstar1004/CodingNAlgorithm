import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt((st.nextToken()));
        int B = Integer.parseInt((st.nextToken()));

        // 1. N을 B로 나눈 나머지를 구하고, B로 나눈다.
        // 2. 이때 가장 마지막 나머지부터 가장 앞 자리값이 된다.
        StringBuilder sb = new StringBuilder();
        while (N > 0){
            int D = N % B;

            if(D < 10){
                sb.append(D);

            } else {
                sb.append((char)(D - 10 + 'A'));
            }

            N = N / B;
        }

        for (int i = sb.length() - 1; i >= 0; i--) {
            System.out.print(sb.charAt(i));
        }
        System.out.println();
    }
}