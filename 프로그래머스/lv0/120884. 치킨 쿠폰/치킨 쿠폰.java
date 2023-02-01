class Solution {
    public int solution(int chicken) {
        int answer = 0;
        // 쿠폰 = 치킨수
        int coupon = chicken;
        
        while(coupon > 9){
            answer += coupon / 10;
            int service = coupon / 10;      // 서비스 치킨
            int leftCouponCnt = coupon % 10;      // 남은 쿠폰
            coupon = leftCouponCnt + service;       // 쿠폰 개수
        }
        
        return answer;
    }
}