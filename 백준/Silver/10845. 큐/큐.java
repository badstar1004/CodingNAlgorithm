import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                int number = Integer.parseInt(command.split(" ")[1]);
                queue.offer(number);

            } else if (command.equals("pop")) {
                Integer polled = queue.poll();

                if (polled == null) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(polled).append("\n");
                }

            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");

            } else if (command.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");

            } else if (command.equals("front")) {
                Integer front = queue.peek();

                if (front == null) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(front).append("\n");
                }

            } else if (command.equals("back")) {
                Integer back = queue.isEmpty() ? null : queue.peekLast();

                if (back == null) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(back).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}