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
        recursion(new StringBuilder(), numbers);
        return primes.size();
    }
    
    // 재귀
    private void recursion(StringBuilder prefix, String numbers) {
        if(prefix.length() > 0) {      // 비어있는걸 확인하려면 isEmpty() 메서드가 더 명확하고 효율적
            int num = Integer.parseInt(prefix.toString());
            
            if(isPrime(num)) {
                primes.add(num);
            }
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                
                prefix.append(numbers.charAt(i));
                
                recursion(prefix, numbers);
                prefix.deleteCharAt(prefix.length() - 1); // 마지막 문자 제거
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