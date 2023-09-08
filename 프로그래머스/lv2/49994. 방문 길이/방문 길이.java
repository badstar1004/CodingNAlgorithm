import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        // set
        Set<String> paths = new HashSet<>();

        int x = 0, y = 0;
        for(char dir : dirs.toCharArray()) {
            int nx = x, ny = y;
            
            switch(dir) {
                case 'U':
                    if(y < 5) {
                        ny++;
                    }
                    break;
                    
                case 'D':
                    if(y > -5) {
                        ny--;
                    }
                    break;
                    
                case 'R':
                    if(x < 5) {
                        nx++;
                    }
                    break;
                    
                case 'L':
                    if(x > -5) {
                        nx--;
                    }
                    break;
            }
            
            if(nx != x || ny != y) {
                paths.add(x + "," + y + "," + nx + "," + ny);
                paths.add(nx + "," + ny + "," + x + "," + y);
                x = nx;
                y = ny;
            }
        }
        
        return paths.size() / 2;
    }
}