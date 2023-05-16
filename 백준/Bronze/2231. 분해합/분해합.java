import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int sum(int num) {
        int generatedNumber = num;

        while (num > 0){
            generatedNumber += num % 10;
            num /= 10;
        }

        return generatedNumber;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 1; i <= N ; i++) {
            if(sum(i) == N){
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}