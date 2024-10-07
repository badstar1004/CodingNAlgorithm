import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 테스트 개수
        int T = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            
            // A 배열, B배열 크기
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[] arrA = new int[N];
            int[] arrB = new int[M];
            
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arrA[j] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < M; k++) {
                arrB[k] = Integer.parseInt(st.nextToken());
            }
            
            // 개수 계산
            int result = countPair(arrA, arrB);
            System.out.println(result);
        }
    }
    
    public static int countPair(int[] arrA, int[] arrB) {
        
        // B 배열 정렬
        Arrays.sort(arrB);
        int count = 0;
        
        for(int aNum : arrA) {
            // aNum 보다 작은 원소 개수 찾음 (이분탐색)
            count += binarySearch(arrB, aNum);
        }
        
        return count;
    }
    
    public static int binarySearch(int[] arrB, int target) {
        int left = 0, right = arrB.length;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if(arrB[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}