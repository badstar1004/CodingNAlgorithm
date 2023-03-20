import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    public static int[] get_alphabet_count(String str){
        int[] count = new int[26];
        
        for(int i = 0; i < str.length(); i++){
            count[str.charAt(i) - 'a']++;
        }
        
        return count;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String A = br.readLine();
		String B = br.readLine();
        
        // 알파벳 소문자 26개
        int[] arrCntA = get_alphabet_count(A);
        int[] arrCntB = get_alphabet_count(B);
        
        // 개수
        int answer = 0;
        for(int i = 0; i < 26; i++){
            // 절대값으로 더해줌
            answer += Math.abs(arrCntA[i] - arrCntB[i]);
            
            /*if(arrCntA[i] > arrCntB[i]){
                answer += arrCntA[i] - arrCntB[i];
            } else if(arrCntA[i] < arrCntB[i]){
                answer += arrCntB[i] - arrCntA[i];
            }*/
        }
        
        System.out.println(answer);
	}
}