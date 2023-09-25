class Solution {
    
    // 시작점 찾기
    private static int[] getStart(String[] park) {
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        
        // 시작점 찾기
        int[] startPosition = getStart(park);
        
        // N, S, W, E
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        
        for(String route : routes) {
            // 진행 방향
            char direction = route.charAt(0);
            
            // 거리
            int distance = Integer.parseInt(route.substring(2));
            
            // 방향 인덱스
            int index = 0;
            if (direction == 'S') {
                index = 1;
            } else if (direction == 'W') {
                index = 2;
            } else if (direction == 'E') {
                index = 3;
            }
            
            boolean valid = true;
            for(int i = 1; i <= distance; i++) {
                // 방향 이동
                int nx = startPosition[0] + dx[index] * i;
                int ny = startPosition[1] + dy[index] * i;
                
                if(nx < 0 || ny < 0
                    || nx >= park.length || ny >= park[0].length()
                    || park[nx].charAt(ny) == 'X') {
                    valid = false;
                    break;
                }
            }
            
            if (valid) {
                startPosition[0] += dx[index] * distance;
                startPosition[1] += dy[index] * distance;
            }
        }
        
        return startPosition;
    }
}