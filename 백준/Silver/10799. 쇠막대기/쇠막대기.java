import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String laser = br.readLine();
        br.close();
        
        // 조각 개수
        int pieceCount = 0;
        // 열린 막대 개수
        int openBarCount = 0;

        for (int i = 0; i < laser.length(); i++) {
            if (laser.charAt(i) == '(') {
                // 다음 문자가 ')' 이면 레이저
                if (i + 1 < laser.length() && laser.charAt(i + 1) == ')') {
                    // 현재까지 열린 막대 개수만큼 조각에 추가
                    pieceCount += openBarCount;
                    // 레이저라 ')' 같이 넘김
                    i++;

                } else {
                    // 새로운 막대 시작
                    openBarCount++;
                }

            } else {
                // 닫힌 막대 처리
                openBarCount--;
                // 닫혔으니 조각 하나 추가
                pieceCount++;
            }
        }

        // 출력
        System.out.println(pieceCount);
    }
}
