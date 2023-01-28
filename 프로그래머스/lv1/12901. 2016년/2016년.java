import java.time.LocalDate;
import java.time.temporal.ChronoField;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        String[] yo = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        
        if((1 <= a && a <=12) && (1 <= b && b <= LocalDate.of(2016, a, 1).lengthOfMonth())) {
            LocalDate date = LocalDate.of(2016, a, b);
            answer = yo[date.get(ChronoField.DAY_OF_WEEK) % 7];
        }
        
        return answer;
    }
}