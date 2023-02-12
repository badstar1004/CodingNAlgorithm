import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        /*
            1. 정렬
            2. ArrayList 생성
            3. 이중 for문
                i + j 값
                ArrayList 확인 후 추가
        */
        
        Arrays.sort(numbers);
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                int sum = numbers[i] + numbers[j];
                
                if(!list.contains(sum)){
                    list.add(sum);
                }
            }
        }
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}