import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 질문 개수
        int N = Integer.parseInt(br.readLine());
        
        // 질문과 결과 저장 배열
        String[] arrGuess = new String[N];
        int[] arrStrike = new int[N];
        int[] arrBall = new int[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            arrGuess[i] = st.nextToken();
            arrStrike[i] = Integer.parseInt(st.nextToken());
            arrBall[i] = Integer.parseInt(st.nextToken());
        }
        
        int possibleAnswer = 0;
        // 123 ~ 987까지
        for(int i = 123; i <= 987; i++) {
            String number = String.valueOf(i);
            
            // 서로 다른 숫자인지 확인
            if(number.charAt(0) == number.charAt(1) ||
              number.charAt(1) == number.charAt(2) ||
              number.charAt(0) == number.charAt(2) ||
              number.contains("0")) {
                continue;
            }
            
            boolean isValid = true;
            // 조건 만족 확인
            for(int j = 0; j < N; j++) {
                int[] result = getStrikeAndBall(arrGuess[j], number);
                if(result[0] != arrStrike[j] || result[1] != arrBall[j]) {
                    isValid = false;
                    break;
                }
            }
            
            if(isValid) {
                possibleAnswer++;
            }
        }
        
        System.out.println(possibleAnswer);
        
    }
    
    
    // 스트라이크, 볼 계산
    public static int[] getStrikeAndBall(String guess, String target) {
        int strike = 0, ball = 0;
        for(int i = 0; i < 3; i++) {
            if(guess.charAt(i) == target.charAt(i)) {
                strike++;
            } else if(target.contains(String.valueOf(guess.charAt(i)))) {
                ball++;
            }
        }
        
        return new int[] {strike, ball};
    }
}