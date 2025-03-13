import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            List<int[]> list = new ArrayList<>();

            // 지원자 수
            int N = Integer.parseInt(br.readLine());
            
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            // 정렬
            list.sort(Comparator.comparingInt(o -> o[0]));

            // 합격자 한명
            int count = 1;
            int min = list.get(0)[1];
            for(int j = 1; j < list.size(); j++) {
                if(list.get(j)[1] < min) {
                    min = list.get(j)[1];
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        br.close();
        // 출력
        System.out.println(sb);
    }
}
