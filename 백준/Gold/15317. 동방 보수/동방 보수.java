import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M;
    static long X;
    static int[] C, S;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 동방 개수
        N = Integer.parseInt(st.nextToken());
        // 동아리 개수
        M = Integer.parseInt(st.nextToken());
        // 지원 최대 금액
        X = Long.parseLong(st.nextToken());
        
        // 동방의 보수 비용
        C = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }
        
        // 동아리 예산
        S = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬 (오름차순)
        Arrays.sort(C);
        Arrays.sort(S);
        
        // 이분 탐색
        int left = 0, right = Math.min(N, M);
        int answer = 0;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(canLocate(mid)) {
                answer = mid;
                left = mid + 1;
                
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
    
    // 동방 배정할 수 있는 지 확인
    public static boolean canLocate(int mid) {
        long addMoney = 0;
        
        for(int i = 0; i < mid; i++) {
            int clubIndex = M - mid + i;  // 동아리 배열의 인덱스 계산
            if (clubIndex < 0 || clubIndex >= M) {
                return false;
            }

            if (C[i] > S[clubIndex]) {
                addMoney += (C[i] - S[clubIndex]);
            }
            
            // X를 초과하면 false
            if(addMoney > X) {
                return false;
            }
        }
        
        return true;
    }
}