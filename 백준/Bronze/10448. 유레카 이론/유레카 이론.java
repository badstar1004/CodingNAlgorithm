import java.io.*;

public class Main {

//    static final boolean[] isEurekaNumber = new boolean[1001];

//    public static void preProcess() {
//        // 1. K보다 작은 삼각수를 모두 구한다.
//        int[] triangleNumbers = new int[50];
//        int triangleNumberCount = 0;
//
//        for (int i = 0; ; i++) {
//            int triangleNumber = i * (i + 1) / 2;
//
//            if (triangleNumber >= 1000) {
//                break;
//            }
//
//            triangleNumbers[triangleNumberCount++] = triangleNumber;
//        }
//
//        // 2. 구해진 삼각수 세개의 합으로 K를 나타낼 수 있는지 확인
//        boolean[] isSumOfTriangleNumber = new boolean[1001];
//        for (int i = 0; i < triangleNumberCount; i++) {
//            for (int j = 0; j < triangleNumberCount; j++) {
//                int sum = triangleNumbers[i] + triangleNumbers[j];
//
//                if(sum < 1000){
//                    isSumOfTriangleNumber[sum] = true;
//                }
//            }
//        }
//
//        for (int i = 0; i < 1000; i++) {
//            if(!isSumOfTriangleNumber[i]){
//                continue;
//            }
//
//            for (int j = 0; j < triangleNumberCount; j++) {
//                int sum = i + triangleNumbers[j];
//
//                if(sum <= 1000){
//                    isEurekaNumber[sum] = true;
//                }
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // [3, 1000]
        // isEurekaNumber[]
//        preProcess();

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[45];
        for (int i = 0; i < 45; i++) {
            arr[i] = i * (i + 1) / 2;
        }

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());

            int ans = 0;
            for (int i = 1; i < 45; i++) {
                for (int j = 1; j < 45; j++) {
                    for (int k = 1; k < 45; k++) {
                        if(arr[i] + arr[j] + arr[k] == K){
                            ans = 1;
                        }
                    }
                }
            }

            System.out.println(ans);
        }

    }
}