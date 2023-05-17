import java.util.Arrays;

public class Main {

    final static int MAX_NUMBER = 10000;

    public static int generate(int num) {
        int generatedNumber = num;

        while (num > 0) {
            generatedNumber += num % 10;
            num /= 10;
        }

        return generatedNumber;
    }

    public static void main(String[] args) {

        boolean[] isSelfNumber = new boolean[MAX_NUMBER + 1];
        Arrays.fill(isSelfNumber, true);

        for (int i = 1; i <= MAX_NUMBER; i++) {
            int num = generate(i);

            if (num <= MAX_NUMBER) {
                isSelfNumber[num] = false;
            }
        }
    
        // 출력
        for (int i = 1; i <= MAX_NUMBER; i++) {
            if (isSelfNumber[i]) {
                System.out.println(i);
            }
        }
    }
}