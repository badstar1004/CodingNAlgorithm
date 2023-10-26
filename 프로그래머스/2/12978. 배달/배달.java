import java.util.Arrays;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i != j) {
                    map[i][j] = 500001;
                }
            }
        }

        for(int i = 0; i < road.length; i++) {
            int start = road[i][0] - 1;
            int end = road[i][1] - 1;
            int value = road[i][2];
            
            map[start][end] = map[end][start] = Math.min(map[start][end], value);
        }
        
        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, 500001);
        dist[0] = 0;
        
        for(int i = 0; i < N; i++) {
            int minIndex = -1;
            int minVal = 500001;

            for(int j = 0; j < N; j++) {
                if(!visited[j] && dist[j] < minVal) {
                    minIndex = j;
                    minVal = dist[j];
                }
            }

            visited[minIndex] = true;

            for(int j = 0; j < N; j++) {
                // 방문 x, 최대값이 아니고, 
                if(!visited[j] && map[minIndex][j] != 500001 && dist[j] > minVal + map[minIndex][j]) {
                    dist[j] = minVal + map[minIndex][j];
                }
            }
        }
        
        for(int d : dist) {
            if(d <= K) {
                answer++;
            }
        }

        return answer;
    }
}