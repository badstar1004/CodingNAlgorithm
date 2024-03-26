import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 나무의 수, 나무의 길이
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        long max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());

            if(max < trees[i]) {
                max = trees[i];
            }
        }

        long min = 0;    // 최소높이
        long result = 0;

        while (min <= max) {
            long mid = min + (max - min) / 2;
            long sum = 0;       // 잘린 나무들 합

            for(long tree : trees) {
                if(tree > mid) {
                    sum += (tree - mid);
                }
            }

            if(sum >= M) {
                min = mid + 1;
                result = mid;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(result);

    }
}