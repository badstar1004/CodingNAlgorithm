import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        
        // BFS
        System.out.println(bfs(A, B));
    }
    
    // BFS
    public static int bfs(long A, long B) {
        Queue<long[]> queue = new LinkedList<>();
        
        // {현재값, 연산횟수}
        queue.offer(new long[]{A, 1});
        
        while(!queue.isEmpty()) {
            long[] cur = queue.poll();
            long curValue = cur[0];
            int count = (int) cur[1];
            
            if(curValue == B) {
                return count;
            }
            
            // * 2
            if (curValue * 2 <= B) {
                queue.offer(new long[]{curValue * 2, count + 1});
            }
            
            // 뒤에 1 붙이기
            if(curValue * 10 + 1 <= B) {
                queue.offer(new long[]{curValue * 10 + 1, count + 1});
            }
        }
        
        return -1;
        
    }
}