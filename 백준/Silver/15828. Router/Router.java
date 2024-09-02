import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N 버퍼 크기
        int N = Integer.parseInt(br.readLine());
        
        // Queue
        Queue<Integer> queue = new LinkedList<>();
        // 출력
        StringBuilder sb = new StringBuilder();
        
        // 처리
        while(true) {
            int packet = Integer.parseInt(br.readLine());
            
            // -1 이면 종료
            if(packet == -1) {
                break;
            }
            
            // 0 보다 큰 경우 추가
            if(packet > 0) {
                // queue 크기 확인
                if(queue.size() < N) {
                    queue.offer(packet);
                }
                
            } else if(packet == 0) {
                // 패킷 하나 처리
                if(!queue.isEmpty()) {
                    queue.poll();
                }
            }
        }
        
        // 출력
        if(queue.isEmpty()) {
            sb.append("empty");
            
        } else {
            while(!queue.isEmpty()) {
                sb.append(queue.poll())
                    .append(" ");
            }
        }
        
        System.out.println(sb.toString());
    }
}