import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N, 게임종류
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char gameType = st.nextToken().charAt(0);
        
        // 각 게임 필요한 최소 인원 설정
        int minPlayer = 0;
        if(gameType == 'Y') {
            minPlayer = 2;
            
        } else if(gameType == 'F') {
            minPlayer = 3;
            
        } else if(gameType == 'O') {
            minPlayer = 4;
        }
        
        // 중복제거 HashSet
        HashSet<String> setPlayer = new HashSet<>();
        // 두번째 줄부터 N개의 줄 입력
        for(int i = 0; i < N; i++) {
            setPlayer.add(br.readLine());
        }
        
        // 게임에 필요한 인원으로 나눔
        int maxGamePlayer = setPlayer.size() / (minPlayer - 1);
        
        // 결과 출력
        System.out.println(maxGamePlayer);
    }
}