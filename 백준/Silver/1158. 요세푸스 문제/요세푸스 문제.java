import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] line = str.split(" ");
        
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (queue.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            
            sb.append(queue.poll()).append(", ");
        }
        
        // 마지막 값
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
	}

}
