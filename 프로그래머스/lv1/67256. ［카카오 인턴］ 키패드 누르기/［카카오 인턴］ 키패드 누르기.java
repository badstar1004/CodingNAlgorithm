import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        // StringBuilder 
        StringBuilder sb = new StringBuilder();
        
        // 키패드 위치
        int[][] keyPad = {{3, 1}, {0, 0}, {0, 1}, {0, 2}    // 0 1 2 3
                        , {1, 0}, {1, 1}, {1, 2}            // 4 5 6
                        , {2, 0}, {2, 1}, {2, 2}};          // 7 8 9
        
        // 엄지 왼손, 오른손 위치
        int[] leftHand = {3, 0};    // *
        int[] rightHand = {3, 2};   // #
        
        for(int num : numbers) {
            // 왼손
            if(num == 1 || num == 4 || num == 7) {
                sb.append("L");
                leftHand = keyPad[num];
                
            // 오른손    
            } else if(num == 3 || num == 6 || num == 9) {
                sb.append("R");
                rightHand = keyPad[num];
            
            // 가까운 손 찾기 (2 5 8 0)    
            } else {
                int[] target = keyPad[num];
                int leftDistance =
                    Math.abs(target[0] - leftHand[0]) + Math.abs(target[1] - leftHand[1]);
                int rightDistance =
                    Math.abs(target[0] - rightHand[0]) + Math.abs(target[1] - rightHand[1]);
                
                // 왼손이 가까울 경우
                if(leftDistance < rightDistance
                   || (leftDistance == rightDistance && hand.equals("left"))) {
                       sb.append("L");
                       leftHand = target;
                    
                 // 오른손이 가까울 경우    
                 } else {
                       sb.append("R");
                       rightHand = target;
                 }
             }
        }
                          
        return sb.toString();
    }
}