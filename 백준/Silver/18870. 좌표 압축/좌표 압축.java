import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arrNum = new int[N];

        // TreeSet 으로 중복제거 후 정렬됨(오름차순)
        TreeSet<Integer> setX = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            arrNum[i] = Integer.parseInt(st.nextToken());
            setX.add(arrNum[i]);
        }

        // 인덱스를 통한 갯수
        HashMap<Integer, Integer> sortedIndex = new HashMap<>();
        int idx = 0;
        for (int num : setX) {
            sortedIndex.put(num, idx++);
        }
        
        // 출력 -> 시간초과
        //for (int i = 0; i < N; i++){
        //    System.out.print(sortedIndex.get(arrNum[i]) + " ");
        //}
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++){
            bw.write(sortedIndex.get(arrNum[i]) + " ");
        }
        bw.flush();

    }
}