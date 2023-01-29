import java.util.stream.*;

class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        String str = IntStream.rangeClosed(i, j).mapToObj(String::valueOf).collect(Collectors.joining());

        return (int) str.chars().mapToObj(Character::toString).filter(c -> c.equals(String.valueOf(k))).count();
    }
}