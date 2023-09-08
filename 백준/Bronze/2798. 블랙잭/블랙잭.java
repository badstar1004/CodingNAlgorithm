import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        // 카드 수, 딜러 숫자
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        // 데이터 삽입
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = 0;
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N - 1; j++) {
                for(int k = j + 1; k < N; k++){
                    int sum = arr[i] + arr[j] + arr[k];
                    
                    if(sum <= M && result < sum) {
                        result = sum;
                    }
                }
            }
        }
        
        System.out.println(result);
    }
}