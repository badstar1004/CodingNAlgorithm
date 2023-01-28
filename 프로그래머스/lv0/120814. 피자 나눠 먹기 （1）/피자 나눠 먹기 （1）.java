class Solution {
    public int solution(int n) {

        if(n < 0 && n > 100){
            return -1;
        }
        
//         // 딱 떨어지는 경우
//         answer = n / 7;
        
//         // 딱 떨어지지 않는 경우
//         if(n % 7 != 0){
//             answer++;
//         }
        
        return ((n % 7) == 0 ? n / 7 : n / 7 + 1);
    }
}