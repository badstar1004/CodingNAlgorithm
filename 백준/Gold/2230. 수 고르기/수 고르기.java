import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 길이 N
        int N = Integer.parseInt(st.nextToken());
        // 차이 M
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        // 정렬
        Arrays.sort(arr);
        
        int left = 0, right = 0, diff = Integer.MAX_VALUE;
        while(right < N) {
            if(arr[right] - arr[left] < M) {
                right++;
                
            } else {
            	diff = Math.min(diff, arr[right] - arr[left]);
            	left++;
                
                if(left > right) {
            		right = left;
            	}
            }
        }
        
        System.out.println(diff);
    }
}