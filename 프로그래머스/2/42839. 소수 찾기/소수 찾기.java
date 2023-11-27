import java.util.*;

class Solution {
    
    // 판별된 소수들
    private Set<Integer> primes = new HashSet<>();
    // 방문 여부
    private boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        
        /*
            변수
                HashSet
                방문여부 배열
            매서드
                재귀
                소수판별
        */
        
        visited = new boolean[numbers.length()];
        recursion("", numbers);
        return primes.size();
    }
    
    private void recursion(String prefix, String numbers) {
        if(prefix != "") {
            int num = Integer.parseInt(prefix);
            
            if(isPrime(num)) {
                primes.add(num);
            }
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                recursion(prefix + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }
    
    // 소수 판별
    private boolean isPrime(int num) {
        if(num <= 1) {
            return false;
        }
        
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}