import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        /*
            1. HashMap 사용
            2. for문 사용
                원하는 물품과 개수를 HashMap iWant 에 추가
                할인행사하는 물품의 개수 HashMap discountProd 에 추가
                iWant 와 discountProd value 값 비교
                전체 물품의 value 가 같거나 iWant 의 value 보다 크다면
                    answer++
        */
        
        // HashMap iWant
        HashMap<String, Integer> iWant = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            iWant.put(want[i], number[i]);
        }
        
        // 일수 (전체 할인 품목 - 10)
        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> discountProd = new HashMap<>();

            // 물품 카운트 추가
            for (int j = i; j < 10 + i; j++) {
                discountProd.put(discount[j], discountProd.getOrDefault(discount[j], 0) + 1);
            }

            boolean isRight = true;
            for(String str : iWant.keySet()){
                // iWant 에 해당하는 물품이 discountProd 에 있고 value 값이 같거나 크면
                if(discountProd.containsKey(str) && (iWant.get(str) <= discountProd.get(str))){
                    continue;
                    
                } else {
                    isRight = false;
                    break;
                }
            }

            if(isRight){
                answer++;
            }
        }
        
        return answer;
    }
}