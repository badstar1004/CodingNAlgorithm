import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];
        for(int i = 0; i < N; i++) {
            arr[i]= Integer.parseInt(br.readLine());
        }

        // x + y = k - z
        // 두개의 합 배열
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                hashSet.add(arr[i] + arr[j]);
            }
        }

        int maxNumber = -1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int target = arr[i] - arr[j];
                if(hashSet.contains(target)) {
                    maxNumber = Math.max(maxNumber, arr[i]);
                }
            }
        }

        System.out.println(maxNumber);
    }
}