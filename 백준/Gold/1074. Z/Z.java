import java.util.*;
import java.io.*;

public class Main {
    
    public static int r, c;
    public static int count;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        // 배열 크기 2^N
        int size = (int) Math.pow(2, N);
        findZ(size, 0, 0);
    }
    
    public static void findZ(int size, int row, int col) {
        // 배열 크기가 1이면 return
        if(size == 1) {
            System.out.println(count);
            return;
        }
        
        int newSize = size / 2;
        
        // r, c 찾기
        if(r < row + newSize && c < col + newSize) {
            // 1사분면
            findZ(newSize, row, col);
            
        } else if (r < row + newSize && c >= col + newSize) {
            // 2사분면
            count += newSize * newSize;
            findZ(newSize, row, col + newSize);
            
        } else if(r >= row + newSize && c < col + newSize) {
            // 3사분면
            count += 2 * newSize * newSize;
            findZ(newSize, row + newSize, col);
            
        } else {
            // 4사분면
            count += 3 * newSize * newSize;
            findZ(newSize, row + newSize, col + newSize);
        }
    }
}