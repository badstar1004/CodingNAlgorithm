class Solution {
    public long[] solution(int n, long left, long right) {
        long[] answer = {};
        
        /*
            1. 문제에 나온 순서대로 풀면되겠다! 했지만 제한사항을 보니 수가 커져 Overflow 가능성이 커짐
                -> 다른 방식으로 접근해야함
            2. 손으로 풀면서 해보니 규칙이 있음
                -> 1 2 3 -> for문으로 행과 열을 구함 (일단 0부터)
                   2 2 3    ex) 0,0 / 0,1
                   3 3 3        행 = i / n, 열 = i % n
                                   = 0 / 3,    = 0 % 3
                                   = 0,0
                                행 = 1 / 3, 열 = 1 % 3
                                   = 0,1
                -> (0,0), (0,1) 인덱스들을 구한 후 값보다 1이 모자른 상황
                -> 0,2 까지 더 해보면 -> 2 + 1 = 3 이 나옴
                -> (Max(행, 열) + 1) 을 해주면 됨
            3. 0,0 부터 구할 필요는 없으니 for 문으로 left ~ right 까지 구하면 됨
        */
        
        int len = (int)(right - left) + 1;
        answer = new long[len];
        
        int idx = 0;    // answer 배열 인덱스
        // for문
        for(long i = left; i <= right; i++){
            answer[idx++] = Math.max((i / n), (i % n)) + 1;
        }
        
        return answer;
    }
}