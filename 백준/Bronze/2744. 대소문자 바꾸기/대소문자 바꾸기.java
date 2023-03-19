import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        String str = br.readLine();
        // StringBuilder
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            
            if(Character.isUpperCase(c)){
                sb.append(String.valueOf(c).toLowerCase());
            } else {
                sb.append(String.valueOf(c).toUpperCase());
            }
        }
        
        br.close();
        System.out.print(sb.toString());
    }
}