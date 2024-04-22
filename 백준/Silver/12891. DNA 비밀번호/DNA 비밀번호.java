import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 임의로 만든 문자열 길이
		int S = Integer.parseInt(st.nextToken());
		// 사용할 부분 문자열 길이
		int P = Integer.parseInt(st.nextToken());

		char[] arr = new char[S];
		String line = br.readLine();
		for (int i = 0; i < S; i++) {
			arr[i] = line.charAt(i);
		}

		// 포함 되어야 할 문자
		String[] line2 = br.readLine().split(" ");
		int[] minRequired = { Integer.parseInt(line2[0]), Integer.parseInt(line2[1]),
							  Integer.parseInt(line2[2]), Integer.parseInt(line2[3]) };

		System.out.println(countValidSubString(line, P, S, minRequired));
	}

	private static int countValidSubString(String line, int P, int S, int[] minRequired) {
		if (P > S) {
			return 0;
		}

		int validCount = 0;
		int[] curCount = new int[4];

		for (int i = 0; i < P; i++) {
			curCount[index(line.charAt(i))]++;
		}

		if (isValid(curCount, minRequired)) {
			validCount++;
		}

		for (int i = P; i < S; i++) {
			curCount[index(line.charAt(i))]++;
			curCount[index(line.charAt(i - P))]--;

			if (isValid(curCount, minRequired)) {
				validCount++;
			}
		}

		return validCount;
	}

	// 해당 인덱스 찾기
	private static int index(char c) {
		switch (c) {
		case 'A':
			return 0;
		case 'C':
			return 1;
		case 'G':
			return 2;
		case 'T':
			return 3;
		default:
			return -1;
		}
	}

	// 개수 차이
	private static boolean isValid(int[] curCount, int[] minRequired) {
		for (int i = 0; i < 4; i++) {
			if (curCount[i] < minRequired[i]) {
				return false;
			}
		}

		return true;
	}

}