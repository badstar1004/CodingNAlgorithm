import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 접시 수
        int N = Integer.parseInt(st.nextToken());
        // 초밥의 가짓수
        int d = Integer.parseInt(st.nextToken());
        // 연속해서 먹는 접시 수
        int k = Integer.parseInt(st.nextToken());
        // 쿠폰 번호
        int c = Integer.parseInt(st.nextToken());
        
        // 초밥의 종류 배열에 넣기
        int[] sushi = new int[N];
        for(int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        
        /* 슬라이딩 윈도우 초기 설정*/
        int[] count = new int[d + 1];
        // 현재 초밥 수
        int curCount = 0;
        // 최종 최대 초밥 수
        int maxCount = 0;
        
        for(int i = 0; i < k; i++) {
            if(count[sushi[i]] == 0) {
                // 새로운 초밥 추가
                curCount++;
            }
            
            count[sushi[i]]++;
        }
        
        maxCount = curCount;
        
        for(int i = 0; i < N; i++) {
            int end = (i + k) % N;
            if(count[sushi[end]] == 0) {
                curCount++;
            }
            
            count[sushi[end]]++;
            
            // 첫번째 삭제
            count[sushi[i]]--;
            if(count[sushi[i]] == 0) {
                curCount--;
            }
            
            // 쿠폰 초밥
            int curMaxCount = curCount;
            if(count[c] == 0) {
                curMaxCount++;
            }
            
            maxCount = Math.max(maxCount, curMaxCount);
        }
        
        System.out.println(maxCount);
    }
}