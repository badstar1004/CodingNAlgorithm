import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static class Cal {

        String serial;
        int sumNumber;

        // 생성자 -> sumNumber 계산
        public Cal(String serial) {
            this.serial = serial;

            for (int i = 0; i < serial.length(); i++) {
                if('0' <= serial.charAt(i) && serial.charAt(i) <= '9') {
                    sumNumber += (serial.charAt(i) - '0');
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        // serial, sumNumber
        Cal[] serialsArr = new Cal[N];
        for (int i = 0; i < N; i++) {
            serialsArr[i] = new Cal(br.readLine());
        }

        // 정렬
        Arrays.sort(serialsArr, (o1, o2) -> {
            // 1번 조건
            if(o1.serial.length() != o2.serial.length()) {
                return o1.serial.length() - o2.serial.length();
            }
            // 2번 조건
            if(o1.sumNumber != o2.sumNumber) {
                return o1.sumNumber - o2.sumNumber;
            }
            // 3번 조건
            return o1.serial.compareTo(o2.serial);
        });

        // 출력
        for (Cal item : serialsArr) {
            System.out.println(item.serial);
        }

    }
}