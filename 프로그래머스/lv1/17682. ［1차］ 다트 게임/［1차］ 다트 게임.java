import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        // 정규표현식으로 그룹핑 ( ) <- 그룹핑

        // 패턴 컴파일
        Pattern pattern = Pattern.compile("([0-9]+)([SDT])([*#]?)");

        // dartResult 패턴 검사
        Matcher matcher = pattern.matcher(dartResult);

        // 스택 사용
        Stack<Integer> stack = new Stack<>();
        while (matcher.find()){
            // 점수
            // 첫번째 그룹 (숫자)
            int num = Integer.parseInt(matcher.group(1));

            // 점수 곱하기 SDT
            // S : 1제곱 -> 자기 자신
            // D : 2제곱
            // T : 3제곱
            if(matcher.group(2).equals("D")){
                num *= num;
            }

            if(matcher.group(2).equals("T")){
                num *= (num * num);
            }

            // 스타상(*) - 해당점수, 바로 전 점수 2배 / 첫번째 나오면 해당점수만 2배
            // 아차상(#) - 해당점수 마이너스
            // 스타상 중첩 - 해당점수 4배
            // 스타상과 아차상 중첩 - 해당점수 -2배
            if(matcher.group(3).equals("*")){
                // 스택이 비어있지않으면
                if(!stack.isEmpty()){
                    // 점수 2배 (바로 전 점수 2배)
                    int peek = stack.pop();
                    stack.push(peek * 2);
                }
                // 해당점수 2배
                num *= 2;
            }

            if(matcher.group(3).equals("#")){
                //해당점수 마이너스
                num *= -1;
            }

            stack.push(num);
        }

        // 스택에서 꺼내면서 계산
        while (!stack.isEmpty()){
            answer += stack.pop();
        }
        
        return answer;
    }
}