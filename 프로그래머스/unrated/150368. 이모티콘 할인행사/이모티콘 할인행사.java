class Solution {
    // 최대 가입자 수
    static int maxMemberCount = 0;
    // 매출액
    static int maxSales = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        // 이모티콘 길이
        int m = emoticons.length;
        
        // 모든 할인율 조합 계산 (n 명 구매기준, 이모티콘 m개 정가, 이모티콘 할인율, 인덱스)
        discountCombinations(users, emoticons, new int[m], 0);
        
        return new int[] {maxMemberCount, maxSales};
    }
    
    // 할인율 조합
    private void discountCombinations(int[][] users, int[] emoticons, int[] discounts, int idx) {
        // 이모티콘 길이까지 다 돌았다면
        if(idx == emoticons.length) {
            // 최대 가입 수, 최대 판매액 갱신
            findMaxValue(users, emoticons, discounts);
            return;
        }
        
        
        for(int i = 1; i <= 4; i++) {
            discounts[idx] = i * 10;
            discountCombinations(users, emoticons, discounts, idx + 1);
        }
    }
    
    // 최대 가입 수, 최대 판매액 찾기
    private void findMaxValue(int[][] users, int[] emoticons, int[] discounts) {
        int totalMemberCount = 0;
        int totalSales = 0;
        
        for(int[] user : users) {
            int userMoney = 0;
            
            for(int i = 0; i < emoticons.length; i++) {
                // 기준 할인율 이상
                if(discounts[i] >= user[0]) {
                    userMoney += emoticons[i] * (100 - discounts[i]) / 100;
                }
            }
            
            // 일정 가격 이상
            if(userMoney >= user[1]) {
                totalMemberCount++;
                
            } else {
                totalSales += userMoney;
            }
        }
        
        // 행사 목적 분기
        if(totalMemberCount > maxMemberCount
            || (totalMemberCount == maxMemberCount && totalSales > maxSales)) {
            maxMemberCount = totalMemberCount;
            maxSales = totalSales;
        }
    }
}