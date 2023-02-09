import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        /*
            LRU : 가장 오래전에 사용된 데이터를 제거하고 새로운 데이터를 삽입하는 알고리즘
                CacheHit : 참조하고자 하는 메모리가 캐시에 존재하고 있을 경우
                CacheMiss : 참조하고자 하는 메모리가 캐시에 존재하지 않을 경우
            LinkedList 사용
                1. cacheSize가 0일 경우
                2. for문 사용
                3. 값 비교를 위해 대소문자 구분하지않아서 소문자로 치환(대문자도 가능)
                4. LinkedList에 값이 있는지 확인(list.remove()는 삭제되면 ture 반환)
                    CacheHit - answer += 1 해주고 해당 데이터를 삭제 후 마지막에 데이터 추가
                5. LinkedList에 값이 없다면
                    CacheMiss
                        answer += 5
                        LinkedList 크기가 cacheSize보다 작다면
                            마지막에 데이터 추가 (추가로직이 같기 때문에 마지막에 한번 작성)
                        LinkedList 크기가 cacheSize와 같다면 (먼저 써주면 작은경우는 없어 됨)
                            제일 첫번째 데이터 삭제
                            마지막에 데이터 추가 (추가로직이 같기 때문에 마지막에 한번 작성)
        */
        
        // LinkedList
        LinkedList<String> lkList = new LinkedList<>();
        int cacheHit = 1;   // cacheHit
        int cacheMiss = 5;  // cacheMiss
        
        // cacheSize가 0일 경우 cacheMiss
        if(cacheSize == 0){
            return cacheMiss * cities.length;
        }
        
        // for문
        for(int i = 0; i < cities.length; i++){
            // 소문자 변환
            String city = cities[i].toLowerCase();
            
            // 데이터가 있을 경우 
            if(lkList.remove(city)){
                answer += 1;
                lkList.add(city);
                
            } else{
                // 데이터가 없을 경우
                answer += 5;
                
                // LinkedList 크기가 cacheSize와 같을 경우
                if(lkList.size() == cacheSize){
                    lkList.removeFirst();
                }
                
                lkList.add(city);
            }
        }
        
        return answer;
    }
}