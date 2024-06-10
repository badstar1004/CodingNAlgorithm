import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        int originalHeight = picture.length;
        int originalWidth = picture[0].length();
        int newHeight = originalHeight * k;
        int newWidth = originalWidth * k;
        
        String[] result = new String[newHeight];
        for(int i = 0; i < originalHeight; i++) {
            StringBuilder[] expandedRows = new StringBuilder[k];
            for(int l = 0; l < k; l++) {
                expandedRows[l] = new StringBuilder(newHeight);
            }
            
            for(int j = 0; j < originalWidth; j++) {
                char ch = picture[i].charAt(j);
                for(int l = 0; l < k; l++) {
                    for(int m = 0; m < k; m++) {
                        expandedRows[l].append(ch);
                    }
                }
            }
            
            for(int l = 0; l < k; l++) {
                result[i * k + l] = expandedRows[l].toString();
            }
        }
        
        return result;
    }
}