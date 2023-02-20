import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        
        /*
            1. HashMap 사용
                A ~ Z 추가
            2. HashMap에서 'w + c' 체크
                    'w + c' 가 없다면 w의 색인 번호 ArrayList에 추가 후 HashMap에 wc 색인 등록
        */
        
        // HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();
        char alph = 'A';

        // for
        for(int i = 1; i <= 26; i++){
            hashMap.put(String.valueOf(alph++), i);
        }

        // ArrayList
        ArrayList<Integer> outList = new ArrayList<>();

        // StringBuilder
        StringBuilder w = new StringBuilder();
        // for
        for(int i = 0; i < msg.length(); i++){
            w.append(msg.charAt(i));
            String wc = "";

            if(i + 1 < msg.length()){
                String c = String.valueOf(msg.charAt(i + 1));
                wc = w + c;

                // hashMap에 있다면
                if (hashMap.containsKey(wc)) {
                    continue;
                }
            }

            // hashMap 없다면
            outList.add(hashMap.get(w.toString()));
            hashMap.put(wc, hashMap.size() + 1);
            // w 초기화
            w.delete(0, w.length());
        }

        answer = new int[outList.size()];
        int idx = 0;
        for(int n : outList){
            answer[idx++] = n;
        }
        
        return answer;
    }
}