import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력값 배열에 담기
        int[] nanjnag = new int[9];
        for(int i = 0; i < 9; i++){
            nanjnag[i] = Integer.parseInt(br.readLine());
        }
        
        // 정렬
        Arrays.sort(nanjnag);

        int sum = Arrays.stream(nanjnag).sum();
        boolean find = false;
        for(int i = 0; i < nanjnag.length; i++){
            for (int j = i + 1; j < nanjnag.length; j++) {
                if(sum - nanjnag[i] - nanjnag[j] == 100){
                    nanjnag[i] = -1;
                    nanjnag[j] = -1;
                    find = true;
                    break;
                }
            }

            if(find){
                break;
            }
        }

        for(Integer num : nanjnag){
            if(num > 0){
                System.out.println(num);
            }
        }
    }
}