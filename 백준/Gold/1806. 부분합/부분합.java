import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 배열 크기 N
        int N = Integer.parseInt(st.nextToken());
        // 연속된 부분합 S
        int S = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0, sum = 0;
        while(true) {
            if(sum >= S) {
                sum -= arr[left++];
                min = Math.min(min, (right - left) + 1);
            } else if(right == N) {
                break;
            } else {
                sum += arr[right++];
            }
        }
        
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}