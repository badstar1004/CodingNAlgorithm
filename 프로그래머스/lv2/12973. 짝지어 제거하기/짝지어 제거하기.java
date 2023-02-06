import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

class Solution{
    public int solution(String s){
        int answer = 0;

        /* ======= HashMap 사용 ======= */
        // 카운트 값 체크 -> 틀린 답 / cdcd하면 바로 옆 문자와 비교를 해야함
//         HashMap<Character, Integer> hashMap = new HashMap<>();
        
//         for(Character c : s.toCharArray()){
//             hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
//         }

//         for(Map.Entry<Character, Integer> val : hashMap.entrySet()){
//             if(val.getValue() % 2 == 0){
//                 answer = 1;
//             }
//         }
        
        /* ======== stack 사용 ======== */
        // 첫 문자 넣고 for문으로 같은거 찾음
        Stack<Character> stack = new Stack<>();
        
        // 첫 문자
        stack.push(s.charAt(0));
        
        for(int i = 1; i < s.length(); i++){
            // stack이 비어있지않고 상위와 같은 문자면
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
                stack.pop();
                // 다른 문자면
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        // stack 사이즈 체크
        if(stack.size() == 0){
            answer = 1;
        }

        return answer;
    }
}