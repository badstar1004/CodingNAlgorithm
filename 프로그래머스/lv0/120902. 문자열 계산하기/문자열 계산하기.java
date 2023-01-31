import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        // 공백 제거 후 자름
        String[] str = my_string.split(" ");

        /* ===== 후위식 표현으로 변경 ===== */
        Stack<String> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < str.length; i++){

            String numOrCal = str[i];

            switch (numOrCal){
                case "+":
                case "-":
                    if(!stack.isEmpty()){
                        list.add(stack.pop());
                    }

                    stack.push(numOrCal);
                    break;
                    
                default:
                    list.add(numOrCal);
            }
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        String[] result = new String[list.size()];

        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        /* ===== 후위식 표현 계산 ===== */
        Stack<Integer> stack1 = new Stack<>();
        for (String s : result){
            if(!s.equals("+") && !s.equals("-")){
                stack1.push(Integer.parseInt(s));
            } else {

                int a = stack1.pop();   // 나중에 들어간 수
                int b = stack1.pop();   // 첫번째 수

                switch (s){
                    case "+":
                        stack1.push(b + a);
                        break;

                    case "-":
                        stack1.push(b - a);
                        break;
                }
            }
        }
        
        return stack1.pop();
    }
}