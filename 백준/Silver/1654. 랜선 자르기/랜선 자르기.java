import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가지고 있는 랜선의 수, 필요한 랜선의 개수
        int K = Integer.parseInt(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        int[] trees = new int[K];

        long max = 0;
        for(int i = 0; i < K; i++) {
            trees[i] = Integer.parseInt(br.readLine());

            if(max < trees[i]) {
                max = trees[i];
            }
        }

        long low = 1;
        long high = max;
        long result = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long count = 0;

            for(int tree : trees) {
                count += (tree / mid);
            }

            if(count >= N) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}