import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long K = Long.parseLong(br.readLine());
        
        // 이진수 변환
        StringBuilder sb = new StringBuilder();
        while(K > 0) {
            if(K % 2 == 0) {
                sb.append("7");
            } else {
                sb.append("4");
            }
            
            // 한자리씩 줄여나가기
            K = (K - 1) / 2;
        }
        
        System.out.println(sb.reverse().toString());
    }
}