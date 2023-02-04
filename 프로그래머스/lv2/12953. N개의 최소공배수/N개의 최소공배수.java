class Solution {
    public int gcd(int a, int b){
        if(a % b == 0){
            return b;
        }
        
        return gcd(b, a % b);
    }
    
    
    public int solution(int[] arr) {
        int answer = 0;
        
        // 배열 길이 1
        if(arr.length == 1){
            return arr[0]; 
        }
        
        // 배열 길이 2 
        // if(arr.length == 2){
        //     int gcd = gcd(arr[0], arr[1]);
        //     return (arr[0] * arr[1]) / gcd;
        // }
        int gcd = gcd(arr[0], arr[1]);
        answer = (arr[0] * arr[1]) / gcd;
        
        // 배열 길이 3 이상
        for(int i = 2; i < arr.length; i++){
            int gc = gcd(answer, arr[i]);
            answer = (answer * arr[i]) / gc;
        }
        
        return answer;
    }
}