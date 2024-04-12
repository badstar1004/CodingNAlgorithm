import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 듣도 못한 사람의 수
        int M = Integer.parseInt(input[1]); // 보도 못한 사람의 수

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        // 결과 저장
        TreeSet<String> result = new TreeSet<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();

            if (map.containsKey(name)) {
                result.add(name);
            }
        }

        // 명수 출력
        System.out.println(result.size());
        // 이름 출력
        for(String name : result) {
            System.out.println(name);
        }
    }
}