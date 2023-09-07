import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        // swap() 함수를 사용하기 위해 ArrayList
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < dungeons.length; i++) {
            list.add(i);
        }
        
        // 순열 탐색 (탐험순서 list, depth, size, 현재 피로도, 던전별(최소 필요 피로도, 소모 피로도))
        permutation(list, 0, dungeons.length, k, dungeons);
        
        return answer;
    }
    
    private void permutation(List<Integer> list, int depth, int len, int k, int[][] dungeons) {
        if(depth == len) {
            int nowK = k;
            int count = 0;
            
            for(int i : list) {
                if(nowK >= dungeons[i][0]) {
                    nowK -= dungeons[i][1];
                    count++;
                }
            }
            
            answer = Math.max(answer, count);
            return;
        }
        
        // swap
        for(int i = depth; i < len; i++) {
            Collections.swap(list, i, depth);
            permutation(list, depth + 1, len, k, dungeons);
            Collections.swap(list, depth, i);
        }
    }
}