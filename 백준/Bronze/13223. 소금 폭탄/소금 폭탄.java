import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // HH:mm:ss
        //
        String[] nowTime = br.readLine().split(":");
        String[] dropTime = br.readLine().split(":");

        // : 기준 자르기
        // nowTime
        int nowH = Integer.parseInt(nowTime[0]);
        int nowM = Integer.parseInt(nowTime[1]);
        int nowS = Integer.parseInt(nowTime[2]);

        // dropTime
        int dropH = Integer.parseInt(dropTime[0]);
        int dropM = Integer.parseInt(dropTime[1]);
        int dropS = Integer.parseInt(dropTime[2]);

        // 시분초 제일 작은 단위로 통합해서 계산한다.
        int nowSecond = nowH * 60 * 60 + nowM * 60 + nowS;
        int dropSecond = dropH * 60 * 60 + dropM * 60 + dropS;

        int gapSecond = dropSecond - nowSecond;
        if(gapSecond <= 0){
            // 24시간을 더해줌
            gapSecond += 24 * 60 * 60;
        }

        int gapH = gapSecond / (60 * 60);
        int gapM = gapSecond % 3600 / 60;
        int gapS = gapSecond % 60;

        String answer = String.format("%02d:%02d:%02d", gapH, gapM, gapS);

        System.out.println(answer);
    }
}