import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 5kg 최대로 사용
        int fiveKg = N / 5;

        // 5kg 봉지를 하나씩 줄여가며 while문 돎
        while (fiveKg >= 0) {
            // 남은 무게
            int remain = N - (fiveKg * 5); 

            // 남은 무게가 3kg으로 나누어 떨어지는 경우
            if (remain % 3 == 0) {
                int threeKg = remain / 3;
                // 출력
                System.out.println(fiveKg + threeKg);
                return;
            }
            
            // 5kg 봉지를 하나 줄이면서 확인
            fiveKg--; 
        }

        // 출력
        System.out.println(-1);
    }
}
