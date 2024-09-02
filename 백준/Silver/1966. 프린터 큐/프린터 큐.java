import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            // 문서 개수 N, 몇번째로 인쇄되는지 M
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            
            // 문서 중요도
            String[] docImportance = br.readLine().split(" ");
            int[] importance = new int[N];
            
            // 큐와 우선순위 큐
            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for(int i = 0; i < N; i++) {
                int priority = Integer.parseInt(docImportance[i]);
                importance[i] = priority;
                queue.offer(new int[] {priority, i});    // 중요도, 인덱스
                pq.offer(priority);
            }
            
            int printSeq = 0;    // 출력 순서
            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                
                // 가장 높은 중요도인지 확인
                if(cur[0] == pq.peek()) {
                    // 출력 +1
                    printSeq++;
                    pq.poll();    // 해당 중요도 제거
                    
                    if(cur[1] == M) {
                        // 몇번째로 인쇄되는지 출력
                        System.out.println(printSeq);
                        break;
                    }
                    
                } else {
                    // 큐 뒤로 이동
                    queue.offer(cur);
                }
            }
        }
    }
}