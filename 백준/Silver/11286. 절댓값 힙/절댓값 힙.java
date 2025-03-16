import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 연산 개수
        int N = Integer.parseInt(br.readLine());
        
        // 우선순위 큐 (절댓값 기준 정렬, 절댓값이 같다면 작은수 우선)
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            
            if (abs1 == abs2) {
                return Integer.compare(o1, o2);
            }
            return Integer.compare(abs1, abs2);
        });
        
        
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            
            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append("0\n");
                    
                } else {
                    sb.append(pq.poll()).append("\n");
                }
                
            } else {
                pq.add(x);
            }
        }

        System.out.print(sb);
    }
}