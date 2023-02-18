import java.util.*;

class Solution {
    
    /*
        DFS
    */
    private int dfs(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }
        
        int ways = 0;
        
        ways += dfs(nums, target, index + 1, sum + nums[index]);
        ways += dfs(nums, target, index + 1, sum - nums[index]);
        
        return ways;
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        /*
            DP
        */
//         int n = numbers.length;
//         int[][] dp = new int[n][2001];
        
//         dp[0][numbers[0] + 1000] = 1;
//         dp[0][-numbers[0] + 1000] += 1;
        
//         for (int i = 1; i < n; i++) {
//             for (int sum = -1000; sum <= 1000; sum++) {
//                 if (dp[i - 1][sum + 1000] > 0) {
//                     dp[i][sum + numbers[i] + 1000] += dp[i - 1][sum + 1000];
//                     dp[i][sum - numbers[i] + 1000] += dp[i - 1][sum + 1000];
//                 }
//             }
//         }
        
        
        /*
            BFS
        */
        int ways = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0); // initialize with zero sum
        
        for (int i = 0; i < numbers.length; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int sum = queue.poll();
                queue.add(sum + numbers[i]);
                queue.add(sum - numbers[i]);
            }
        }
        
        while (!queue.isEmpty()) {
            if (queue.poll() == target) {
                ways++;
            }
        }
        
        // BFS return
        return ways;
        
        // DP return
        // return target > 1000 ? 0 : dp[n - 1][target + 1000];
        
        // DFS return
        // return dfs(numbers, target, 0, 0);
    }
}