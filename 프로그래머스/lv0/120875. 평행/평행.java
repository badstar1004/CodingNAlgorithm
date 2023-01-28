import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        // 평행선은 기울기가 평행함
        // y2 - y1 / x2 - x1
        ArrayList<Double> list = new ArrayList<>();
        
        for(int i = 0; i < dots.length; i++){
            if(answer == 1){
                break;
                
            } else {
                for(int j = i + 1; j < dots.length; j++){
                    double cal = (double)(dots[i][1] - dots[j][1]) / (dots[i][0] - dots[j][0]);
                    
                    if(list.contains(cal)){
                        answer = 1;
                        break;
                        
                    } else {
                        list.add(cal);
                    }
                }
            }
        }

        return answer;
    }
}