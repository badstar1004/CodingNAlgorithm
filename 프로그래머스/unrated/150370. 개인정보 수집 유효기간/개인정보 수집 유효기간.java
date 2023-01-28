import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        if(terms.length > 20 || privacies.length > 100){
            return new int[] {};
        }
        
        DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, dtf);
        
        int[] termsAll = new int[26];
        for(String term: terms) {
            String[] ts =  term.split(" ");
            termsAll[ts[0].charAt(0) -'A'] = Integer.parseInt(ts[1]);
        }
        
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i<privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            
            LocalDate privacyDate = LocalDate.parse(privacy[0], dtf).plusMonths(termsAll[privacy[1].charAt(0) - 'A']).minusDays(1);
            
            if (privacyDate.isBefore(todayDate)) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}