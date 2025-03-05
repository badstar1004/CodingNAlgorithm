import java.io.*;
import java.util.*;
    
public class Main {
    static int K;
    static int[] arrR;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // K
            K = Integer.parseInt(st.nextToken());
            if(K == 0) {
                break;
            }

            // R배열
            arrR = new int[K];
            for(int i = 0; i < K; i++) {
                arrR[i] = Integer.parseInt(st.nextToken());
            }

            result = new int[6];
            visited = new boolean[K];
            backTracking(0, 0);

            // 각 테스트 구분
            sb.append('\n');
        }

        // 출력
        System.out.print(sb.toString());
    }

    // 백트레킹
    private static void backTracking(int start, int depth) {
        // 6개가 되면 문자열 생성
        if(depth == 6) {
            for(int item : result) {
                sb.append(item).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i = start; i < K; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = arrR[i];
                backTracking(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
