import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        // 홀수인 경우에는 +1 짝수인 경우엔 *2 를 함
        // n부터 거꾸로 내려가는걸로 생각하면
        // 홀수: ans++, n-- / 짝수: n /= 2;
        // while문
        while(n > 0){
            // 짝수일 경우
            if(n % 2 == 0){
                n /= 2;
                // 홀수 일 경우
            } else{
                n--;
                ans++;
            }
        }

        return ans;
    }
}