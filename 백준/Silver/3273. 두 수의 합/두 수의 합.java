import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        boolean[] exist = new boolean[10000001];
        for (int i = 0; i < N; i++) {
            exist[arr[i]] = true;
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int pairVal = X - arr[i];

            if(0 <= pairVal && pairVal <= 1000000){
                ans += exist[pairVal] ? 1 : 0;
            }
        }

        System.out.println(ans / 2);
    }
}
