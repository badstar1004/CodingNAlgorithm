import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] videos = new int[N];
		int left = 0, right = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			videos[i] = Integer.parseInt(st.nextToken());
			left = Math.max(left, videos[i]);
			right += videos[i];
		}
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			int sum = 0, count = 0;
			
			for(int i = 0; i < N; i++) {
				if(sum + videos[i] > mid) {
					count++;
					sum = 0;
				}
				
				sum += videos[i];
			}
			
			if(sum > 0) {
				count++;
			}
			
			if(count > M) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(left);
	}

}