import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 이동하려는 채널
        int targetChannel = Integer.parseInt(br.readLine());
        // 고장난 버튼 수
        int brokenCount = Integer.parseInt(br.readLine());
        // 고장난 버튼 배열
        boolean[] brokenButtons = new boolean[10];
        
        
        // 고장난 버튼이 있을때
        if(brokenCount > 0) {
            String[] broken = br.readLine().split(" ");
            for(int i = 0; i < brokenCount; i++) {
                brokenButtons[Integer.parseInt(broken[i])] = true;
            }
        }
        
        // 현재 채널은 100번임, +/- 로만 이동 할 경우
        int minPressCount = Math.abs(targetChannel - 100);
        
        // 0부터 999999까지 모든 채널 확인
        for(int i = 0; i <= 999999; i++) {
            String channel = String.valueOf(i);
            
            // 고장난 버튼인가
            boolean isPossible = true;
            for(int j = 0; j < channel.length(); j++) {
                int digit = channel.charAt(j) - '0';
                if(brokenButtons[digit]) {
                    isPossible = false;
                    break;
                }
            }
            
            // 만들 수 있다면 경우의 수 계산
            if(isPossible) {
                int pressCount = channel.length() + Math.abs(i - targetChannel);
                minPressCount = Math.min(minPressCount, pressCount);
            }
        }
        
        System.out.println(minPressCount);
        
    }
}