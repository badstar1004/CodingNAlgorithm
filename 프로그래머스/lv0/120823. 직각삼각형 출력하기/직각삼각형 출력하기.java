import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if((n < 1) && (n > 10)){
            System.out.println("제한사항 조건에 벗어났습니다.");
            return;
        }
        
        for(int i = 1; i <= n; i++){
            System.out.println("*".repeat(i));
        }
    }
}