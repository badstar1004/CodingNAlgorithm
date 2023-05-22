import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        // HashMap 제목 넣기
        HashMap<String, Integer> titles = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            titles.put(title, titles.getOrDefault(title, 0) + 1);
        }

        String maxTitle = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> item : titles.entrySet()) {
            // 횟수가 maxCount 보다 크거나 횟수가 같고 사전순 앞순서면
            if (item.getValue() > maxCount
                    || (item.getValue() == maxCount && item.getKey().compareTo(maxTitle) < 0)) {
                maxTitle = item.getKey();
                maxCount = item.getValue();
            }
        }
        System.out.println(maxTitle);

    }
}