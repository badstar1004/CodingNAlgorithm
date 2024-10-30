import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 탑의 수
        int N = Integer.parseInt(br.readLine());
        // 탑 높이 배열
        int[] arrHeight = new int[N];
        // 탑 인덱스
        int[] arrIndex = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arrHeight[i] = Integer.parseInt(st.nextToken());
        }
        
        // Stack 사용
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            // 높이가 스택 높이보다 클때까지 pop
            while(!stack.isEmpty() && arrHeight[stack.peek()] <= arrHeight[i]) {
                stack.pop();
            }
            
            if(!stack.isEmpty()) {
                arrIndex[i] = stack.peek() + 1;
                
            } else {
                arrIndex[i] = 0;
            }
            
            stack.push(i);
        }
        
        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(arrIndex[i]).append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }
}