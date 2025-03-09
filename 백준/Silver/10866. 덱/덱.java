import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/* switch 문으로 */
public class Main {

    private static Deque<Integer> deque = new ArrayDeque<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            command(br.readLine().split(" "));
        }

        System.out.print(sb); // 결과 한 번에 출력

    }

    private static void command(String[] str) {
        String command = str[0];

        switch(command) {
            case "push_front":
                deque.addFirst(Integer.parseInt(str[1]));
                break;
            case "push_back":
                deque.addLast(Integer.parseInt(str[1]));
                break;
            case "pop_front":
                sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
                break;
            case "pop_back":
                sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
                break;
            case "size":
                sb.append(deque.size()).append("\n");
                break;
            case "empty":
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                break;
            case "front":
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                break;
            case "back":
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                break;
        }
    }
}
