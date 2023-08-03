import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] numbers) {
        return IntStream.range(0, 10)
            .filter(i -> Arrays.stream(numbers).noneMatch(num -> i == num)).sum();
    }
}