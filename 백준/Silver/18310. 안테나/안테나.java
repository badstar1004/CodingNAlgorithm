import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer[] house = new Integer[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(house);
        // 중간 출력
        System.out.println(house[(N - 1) / 2]);

    }
}