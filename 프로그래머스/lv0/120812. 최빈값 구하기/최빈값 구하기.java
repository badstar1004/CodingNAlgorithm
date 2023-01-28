import java.util.*;

class Solution {
    public int solution(int[] array) {
    
        // HashMap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // 값 초기화
        int answer = 0, max = -1, maxCnt = 0;
        
        for(int i = 0; i < array.length; i++){
            // map에 넣기
            int cnt = map.getOrDefault(array[i], 0) + 1;
            map.put(array[i], cnt);
            
            if(maxCnt < cnt) {
                max = array[i];
                maxCnt = cnt;
            }
        }
        
        // 최빈값이 여러개인지 확인
        for(Integer i : map.keySet()){
            if(map.get(i) == maxCnt && i != max){
                return -1;
            }
        }
        
        return max;
    }
}