import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 단어 개수
        int N = Integer.parseInt(br.readLine());
        
        // 단어 배열
        String[] words = new String[N];
        for(int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        
        /* 자릿수 마다 가중치 두기 */
        // 가중치 Map
        Map<Character, Integer> weightMap = new HashMap<>();
        for(String word : words) {
            int len = word.length();
            
            // 각 자릿수 알파벳
            for(int i = 0; i < len; i++) {
                char c = word.charAt(i);
                int weight = (int) Math.pow(10, len - i - 1);
                weightMap.put(c, weightMap.getOrDefault(c, 0) + weight);
            }
        }
        
        // 가중치 리스트
        List<Integer> weightList = new ArrayList<>(weightMap.values());
        // 정렬 (내림차순)
        Collections.sort(weightList, Collections.reverseOrder());
        
        // 큰 가중치부터 할당
        int num = 9;
        int result = 0;
        for(int weight : weightList) {
            result += (weight * num);
            num--;
        }
        
        // 출력
        System.out.println(result);
    }
}