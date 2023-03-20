import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    public static int[] getAlphabetCount(String str){
        int[] count = new int[26];
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            
            if('A' <= ch && ch <= 'Z'){
                count[ch - 'A']++;
            } else {
                count[ch - 'a']++;
            }
        }
        
        return count;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String A = br.readLine();
		String B = br.readLine();
        
        // 알파벳 소문자 26개
        int[] arrCntA = getAlphabetCount(A);
        
        // 개수
        int maxCount = -1;
        char maxAlphabet = '?';
        for(int i = 0; i < 26; i++){
            if(arrCntA[i] > maxCount){
                maxCount = arrCntA[i];
                maxAlphabet = (char)('A' + i);
            } else if(arrCntA[i] == maxCount){
                maxAlphabet = '?';
            }
        }
        
        System.out.println(maxAlphabet);
	}
}