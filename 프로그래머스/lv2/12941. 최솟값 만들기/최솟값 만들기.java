import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        // 최소/최대를 위해 정렬 (최소 * 최대)
        Arrays.sort(A);
        Arrays.sort(B);
        
        // for문 계산
        for(int i = 0; i < A.length; i++){
            answer += (A[i] * B[B.length - i - 1]); 
        }

        return answer;
    }
}