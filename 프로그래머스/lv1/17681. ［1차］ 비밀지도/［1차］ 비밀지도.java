class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        if(n < 1 || n > 16 || arr1.length != n || arr2.length != n){
            return null;
        }
        
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){

            String str = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            StringBuilder stringBuilder = new StringBuilder();
            str = String.format("%" + n + "s", str);
            
            str = str.replace('1', '#').replace('0', ' ');
            
            answer[i] = str;
        }
        
        return answer;
    }
}