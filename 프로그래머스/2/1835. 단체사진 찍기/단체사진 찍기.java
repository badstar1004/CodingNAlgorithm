class Solution {
    private static int answer = 0;
    private static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    
    public int solution(int n, String[] data) {
        answer = 0;
        boolean[] visited = new boolean[8];
        backtracking("", visited, data);
        
        return answer;
    }
    
    
    private static void backtracking(String permutation, boolean[] visited, String[] data) {
        if (permutation.length() == 8) {
            if (isValid(permutation, data)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String newPermutation = permutation + friends[i];
                backtracking(newPermutation, visited, data);
                visited[i] = false;
            }
        }
    }
    
    
    private static boolean isValid(String permutation, String[] conditions) {
        for (String condition : conditions) {
            int pos1 = permutation.indexOf(condition.charAt(0));
            int pos2 = permutation.indexOf(condition.charAt(2));
            char operator = condition.charAt(3);
            int distance = condition.charAt(4) - '0';
            int actualDistance = Math.abs(pos1 - pos2) - 1;

            if (!satisfiesCondition(actualDistance, distance, operator)) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean satisfiesCondition(int actual, int expected, char operator) {
        switch (operator) {
            case '=':
                return actual == expected;
            case '<':
                return actual < expected;
            case '>': 
                return actual > expected;
            default:
                return false;
        }
    }
}