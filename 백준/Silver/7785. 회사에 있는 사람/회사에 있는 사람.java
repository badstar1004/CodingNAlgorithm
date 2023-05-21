import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        String[][] member = new String[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            member[i][0] = st.nextToken();
            member[i][1] = st.nextToken();
        }

        Arrays.sort(member, (o1, o2) -> o2[0].compareTo(o1[0]));

        for (int i = 0; i < N - 1; i++) {
            if(!member[i][0].equals(member[i + 1][0]) && member[i][1].equals("enter")){
                System.out.println(member[i][0]);
            }
        }

        if(member[N - 1][1].equals("enter")){
            System.out.println(member[N - 1][0]);
        }

    }
}