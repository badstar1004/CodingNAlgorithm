import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println(hanSu(Integer.parseInt(br.readLine())));
    }
                           
    public static int hanSu(int isHansu) {
        int count = 99; // 한수 카운트
        
        // 100 미만 수는 한수
        if(isHansu < 100) {
            return isHansu;
        }
        
        for (int i = 100; i <= isHansu; i++) {
            int hun = i / 100; // 백의 자릿수
            int ten = (i / 10) % 10; // 십의 자릿수
            int one = i % 10;

            if ((hun - ten) == (ten - one)) { // 각 자릿수가 수열을 이루면
                count++;
            }
        }
        
        return count;
    }
}