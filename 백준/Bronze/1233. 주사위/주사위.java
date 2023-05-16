import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S1 = Integer.parseInt(st.nextToken());
        int S2 = Integer.parseInt(st.nextToken());
        int S3 = Integer.parseInt(st.nextToken());

        int maxNum = S1 + S2 + S3;
        int[] countArr = new int[maxNum + 1];

        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    countArr[i + j + k]++;
                }
            }
        }

        int ans = 1;
        int ansCount = countArr[1];
        for (int i = 2; i <= maxNum; i++)
            if (countArr[i] > ansCount) {
                ans = i;
                ansCount = countArr[i];
            }

        System.out.println(ans);
    }
}