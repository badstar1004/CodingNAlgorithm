import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] numbers, String direction) {

        if((numbers.length < 3 && numbers.length > 20) && (direction != "left" && direction != "right")){
            return null;
        }
        
        int[] answer = new int[numbers.length];
        ArrayList<Integer> list = new ArrayList<>();

        for (int a: numbers) {
            list.add(a);
        }

        if(direction.equals("right")){
            Collections.rotate(list, 1);
        } else if (direction.equals("left")) {
            Collections.rotate(list, -1);
        }

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}