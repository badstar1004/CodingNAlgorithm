import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        // Stack
        Stack<Integer> hamburgerStack = new Stack<>();
        for(int order : ingredient) {
            hamburgerStack.push(order);
            
            if(hamburgerStack.size() >= 4) {
                int fourth = hamburgerStack.get(hamburgerStack.size() - 4);     // 빵
                int third = hamburgerStack.get(hamburgerStack.size() - 3);      // 야채
                int seconds = hamburgerStack.get(hamburgerStack.size() - 2);    // 고기
                int first = hamburgerStack.get(hamburgerStack.size() - 1);      // 빵
                
                if(fourth == 1 && third == 2 && seconds == 3 && first == 1) {
                    answer++;
                
                    // Stack 빼기
                    for(int i = 0; i < 4; i++) {
                        hamburgerStack.pop();
                    }
                }
            }
        }
        
        return answer;
        // ArrayList
//         ArrayList<Integer> al = new ArrayList<>();
//         for(int i : ingredient) {
//             al.add(i);
            
//             if(al.size() >= 4) {
//                 if(al.get(al.size()-4)==1&&al.get(al.size()-3)==2&&al.get(al.size()-2) == 3&&al.get(al.size()-1)==1){
//                     answer ++;
//                     al.remove(al.size()-4);                                   
//                     al.remove(al.size()-3);
//                     al.remove(al.size()-2);
//                     al.remove(al.size()-1);
//                 }
//             }
//         }
        
    }
}