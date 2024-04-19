import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static long T;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T
        T = Long.parseLong(br.readLine());    // 구하려는 합
        N = Integer.parseInt(br.readLine());    // N

        int[] aArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        int[] bArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        long count = getCount(aArr, bArr);
        System.out.println(count);

    }

    private static long getCount(int[] aArr, int[] bArr) {
        Map<Long, Long> subA = new HashMap<>();
        Map<Long, Long> subB = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long sum = 0;
            for (int j = i; j < N; j++) {
                sum += aArr[j];
                Long count = subA.getOrDefault(sum, 0L);
                subA.put(sum, count + 1);
            }
        }

        for (int i = 0; i < M; i++) {
            long sum = 0;
            for (int j = i; j < M; j++) {
                sum += bArr[j];
                Long count = subB.getOrDefault(sum, 0L);
                subB.put(sum, count + 1);
            }
        }

        long count = 0;
        for (Map.Entry<Long, Long> entry : subA.entrySet()) {
            Long aKey = entry.getKey();
            Long aValue = entry.getValue();
            long bKey = T - aKey;
            Long bValue = subB.getOrDefault(bKey, 0L);
            count += (aValue * bValue);
        }

        return count;
    }
}