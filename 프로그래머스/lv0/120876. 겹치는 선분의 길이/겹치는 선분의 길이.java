class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        // 200길이 배열 선언 (-100 ~ 100)
        int[] arr = new int[200];
        
        // for문
        for(int i = 0; i < lines.length; i++){
            // ex) 2 ~ 4까지 카운트
            for(int j = lines[i][0] + 100; j < lines[i][1] + 100; j++){
                arr[j]++;
            }
        }
        
        // 1보다 큰 수 세기
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 1){
                answer++;
            }
        }
        
        return answer;
    }
}