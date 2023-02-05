import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());
        // StringBuilder
        StringBuilder str = new StringBuilder();
        
        // 체스 말 개수 (킹, 퀸, 룩, 비숍, 나이트, 폰)
        int[] chess = {1, 1, 2, 2, 2, 8};
        
        // for문
        for(int i = 0; i < chess.length; i++){
            str.append(chess[i] - Integer.parseInt(st.nextToken()))
               .append(" ");
        }
        
        br.close();
        System.out.print(str);
    }
}