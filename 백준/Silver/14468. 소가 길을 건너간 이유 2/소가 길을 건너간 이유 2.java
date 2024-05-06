import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        // 배열 초기화
        int[][] positions = new int[26][2];
        for (int i = 0; i < 26; i++) {
            positions[i][0] = -1;
            positions[i][1] = -1;
        }

        for(int i = 0; i < line.length(); i++) {
            int cow = line.charAt(i) - 'A';

            // 진입
            if(positions[cow][0] == -1) {
                positions[cow][0] = i;
            } else {
                // 출구
                positions[cow][1] = i;
            }
        }

        // 찾기
        int count = 0;
        for(int i = 0; i < 26; i++) {
            for(int j = i + 1; j < 26; j++) {
                if((positions[i][0] < positions[j][0] && positions[j][0] < positions[i][1] && positions[i][1] < positions[j][1])
                || (positions[j][0] < positions[i][0] && positions[i][0] < positions[j][1] && positions[j][1] < positions[i][1])) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}