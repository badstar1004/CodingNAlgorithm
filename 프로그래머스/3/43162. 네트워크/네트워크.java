class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // 방문 여부
        boolean[] visited = new boolean[n];
        int networkCount = 0;
        
        for(int i = 0; i < n; i++) {
            // 방문하지 않았다면
            if(!visited[i]) {
                dfs(i, computers, visited);
                
                networkCount++;
            }
        }
        
        return networkCount;
    }
    
    
    // dfs
    private void dfs(int network, int[][] computers, boolean[] visited) {
        // 방문 여부 변경
        visited[network] = true;
        
        for(int i = 0; i < computers.length; i++) {
            if(computers[network][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }
}