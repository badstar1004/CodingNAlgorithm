import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int cnt = 0;

        // 홀수: ans += 1, n-- / 짝수: n /= 2;
        // while문
        while(n > 0){
            if(n % 2 == 0){
                n /= 2;
            } else{
                n--;
                ans++;
            }
        }

        return ans;
    }
}