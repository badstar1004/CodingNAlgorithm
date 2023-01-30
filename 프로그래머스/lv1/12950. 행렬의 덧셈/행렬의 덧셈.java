class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 같은 결과가 나와서 사이즈 고정
        int[][] answer = new int[arr1.length][arr1[0].length];
        
        // 행렬 덧셈 반복
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[0].length; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
        
        return answer;
    }
}