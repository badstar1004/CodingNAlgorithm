import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // A 배열 크기
        int N = Integer.parseInt(st.nextToken());
        // B 배열 크기
        int M = Integer.parseInt(st.nextToken());
        
        // A 배열
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        // B 배열
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
        	list.add(Integer.parseInt(st.nextToken()));
        }
        
        // 정렬
        Collections.sort(list);
        
        // StringBuilder 담기
        StringBuilder sb = new StringBuilder();
        for(int n : list) {
            sb.append(n + " ");
        }
        
        System.out.println(sb);
    } 
}