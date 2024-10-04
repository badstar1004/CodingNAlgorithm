import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 방 번호
        String roomNumber = br.readLine();
        
        // 0 ~ 9 횟수 배열
        int[] numberCount = new int[10];
        
        // 방번호의 빈도수
        for(int i = 0; i < roomNumber.length(); i++) {
            int num = roomNumber.charAt(i) - '0';
            numberCount[num]++;
        }
        
        // 6, 9 개수 합침
        int sixNineCount = numberCount[6] + numberCount[9];
        numberCount[6] = numberCount[9] = (sixNineCount + 1) / 2;
        
        // 가장 많이 필요한 숫자의 세트 수
        int maxSet = 0;
        for (int i = 0; i < 9; i++) {  // 0 ~ 8까지
            maxSet = Math.max(maxSet, numberCount[i]);
        }
        
        // 출력
        System.out.println(maxSet);
    }
}