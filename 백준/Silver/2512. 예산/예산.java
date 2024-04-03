import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 지방의 수
		int N = Integer.parseInt(br.readLine());
		
		int left = 0, right = -1;
		int[] numArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, numArr[i]);
		}
		
		// 총 예산
		int M = Integer.parseInt(br.readLine());
		Arrays.sort(numArr);
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			long budget = 0;
			
			for(int i = 0; i < N; i++) {
				if(numArr[i] > mid) {
					budget += mid;
				} else {
					budget += numArr[i];
				}
			}
			
			if(budget <= M) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		
		System.out.println(right);
	}

}
