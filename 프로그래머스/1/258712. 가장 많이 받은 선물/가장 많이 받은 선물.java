import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
         // 각 선물 지수 map
        Map<String, Integer> giftIndex = new HashMap<>();

        // 각 친구간 선물 교환 횟수 map /    준사람/받은사람,?개
        Map<String, Map<String, Integer>> giftExchange = new HashMap<>();

        // 다음 달 선물 받을 횟수 map
        Map<String, Integer> nextMonthGifts = new HashMap<>();
        
        // 초기화
        for (String friend : friends) {
            giftIndex.put(friend, 0);
            giftExchange.put(friend, new HashMap<>());
            nextMonthGifts.put(friend, 0);
        }
        
        // 선물 교환 기록
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            String giveFriend = split[0];   // 준 친구
            String receiveFriend = split[1];   // 받은 친구

            // 선물 교환
            giftExchange.get(giveFriend)
                    .put(receiveFriend, giftExchange.get(giveFriend).getOrDefault(receiveFriend, 0) + 1);

            // 선물 지수 계산
            giftIndex.put(giveFriend, giftIndex.get(giveFriend) + 1);
            giftIndex.put(receiveFriend, giftIndex.get(receiveFriend) - 1);
        }
        
        // System.out.println("각 선물 지수: " + giftIndex);
        // System.out.println("각 선물 준 사람/개수: " + giftExchange);
        
        // 선물 교환 계산
        for(int i = 0; i < friends.length; i++) {
            // 준 사람
            String give = friends[i];

            for(int j = i + 1; j < friends.length; j++) {
                // 받은 사람
                String receive = friends[j];

                // 준 친구 -> 받은 친구
                int giveToReceive = giftExchange.get(give).getOrDefault(receive, 0);
                // 받은 친구 -> 준 친구
                int receiveToGive = giftExchange.get(receive).getOrDefault(give, 0);

//                System.out.println("giveToReceive: " + give);
//                System.out.println("receiveToGive: " + receive);

                // 계산
                /*
                    1. 두 사람이 선물을 주고받은 기록이 있다면,
                    이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
                */
                if (giveToReceive > receiveToGive) {
                    nextMonthGifts.put(give, nextMonthGifts.getOrDefault(give, 0) + 1);
                }
                else if(receiveToGive > giveToReceive) {
                    nextMonthGifts.put(receive, nextMonthGifts.getOrDefault(receive, 0) + 1);
                }
                /*
                    2. 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면,
                */
                else {
                    // 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
                    if (giftIndex.get(give) > giftIndex.get(receive)) {
                        nextMonthGifts.put(give, nextMonthGifts.getOrDefault(give, 0) + 1);

                    } else if (giftIndex.get(receive) > giftIndex.get(give)) {
                        nextMonthGifts.put(receive, nextMonthGifts.getOrDefault(receive, 0) + 1);
                    }
                }
            }
        }
        
        // System.out.println("다음달 선물 받는 사람: " + nextMonthGifts);
        
        return nextMonthGifts.values().stream().max(Integer::compare).orElse(0);
    }
}