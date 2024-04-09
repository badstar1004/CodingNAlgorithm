import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push" :
                    int value = Integer.parseInt(st.nextToken());
                    stack.push(value);
                    break;
                case "pop" :
                    System.out.println(stack.isEmpty() ? -1 : stack.pop());
                    break;
                case "size" :
                    System.out.println(stack.size());
                    break;
                case "empty" :
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case "top" :
                    System.out.println(stack.isEmpty() ? -1 : stack.peek());
                    break;
            }
        }

    }
}