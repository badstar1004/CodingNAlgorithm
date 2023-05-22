import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        StringTokenizer stDtl = new StringTokenizer(br.readLine());

        // LinkedHashMap 에 입력 추가 (먼저 나온 것이 앞에 있어야 한다 → LinkedHashMap 은 들어간 순서가 지켜짐)
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(stDtl.nextToken());
            linkedHashMap.put(key, linkedHashMap.getOrDefault(key, 0) + 1);
        }

        Integer[] keySet = linkedHashMap.keySet().toArray(new Integer[linkedHashMap.size()]);
        // 정렬
        Arrays.sort(keySet, (o1, o2) -> linkedHashMap.get(o2).compareTo(linkedHashMap.get(o1)));
        for (int item : keySet) {
            // key 에 대한 value 값
            int count = linkedHashMap.get(item);
            while (count -- > 0){
                System.out.print(item + " ");
            }
        }
        System.out.println();

    }
}