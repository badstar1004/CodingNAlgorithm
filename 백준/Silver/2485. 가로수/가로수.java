import java.io.*;

/* 유클리드 호제법 사용 최대공약수 */
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       // 가로수 개수
       int N = Integer.parseInt(br.readLine());

       // 가로수 배열
       int[] trees = new int[N];
       for(int i = 0; i < N; i++) {
           trees[i] = Integer.parseInt(br.readLine());
       }

       // 가로수 차이
       int[] diffs = new int[N - 1];
       for(int i = 0; i < N - 1; i++) {
           // System.out.println("차이: " + (trees[i + 1] - trees[i]));
           diffs[i] = trees[i + 1] - trees[i];
       }

       // 최대공약수
       int gcd = diffs[0];
       for(int i = 1; i < diffs.length; i++) {
           // System.out.println("최대공약수: " + (gcd(gcd, diffs[i])));
           gcd = gcd(gcd, diffs[i]);
       }

       // 추가 가로수
       int newTrees = 0;
       for(int diff : diffs) {
           // System.out.println("추가 가로수: " + ((diff / gcd) - 1));
           newTrees += (diff / gcd) - 1;
       }

        System.out.println(newTrees);
    }

    // 최대공약수
    private static int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
