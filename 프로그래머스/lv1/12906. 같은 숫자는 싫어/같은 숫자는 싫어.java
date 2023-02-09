import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        /*
            1. ArrayList 사용
            2. num = 0번 인덱스를 미리 뽑아놓고 ArrayList에 추가
            3. for문
                뽑아 놓은 0번 인덱스와 같지 않으면
                    ArrayList 추가
                    num = 추가한 데이터
            4. int 형 배열로 변환 (for문)
        */
        
        // ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        
        int num = arr[0];
        list.add(num);
        for(int i = 0; i < arr.length; i++){
            if(num != arr[i]){
                list.add(arr[i]);
                num = arr[i];
            }
        }
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}