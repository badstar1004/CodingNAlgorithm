import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        // 단어 개수
        int N = Integer.parseInt(br.readLine());

        // 단어 배열
        String[] word = new String[N];
        for (int i = 0; i < N; i++) {
            word[i] = br.readLine();
        }

        Arrays.sort(word, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        System.out.println(word[0]);
        for (int i = 1; i < N; i++) {
            if(!word[i].equals(word[i - 1])) {
                System.out.println(word[i]);
            }
        }
    }
}