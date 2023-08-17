class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int n = s.length();
        
        // 길이가 1일 경우
        if(n == 1) {
            return 1;
        }
        
        // 최대 길이로
        answer = n;
        
        // for 1개부터 전체의 반까지
        for(int i = 1; i <= n / 2; i++) {
            
            // 이전 문자열?
            String prevStr = s.substring(0, i);
            // System.out.println(prevStr); -> a, ab, abc
            
            int count = 1;
            StringBuilder sb = new StringBuilder();
            
            // 슬라이딩 윈도우 느낌?
            for(int j = i; j < n; j += i) {
                
                // 단위
                String sub;
                if(j + i < n) {
                    sub = s.substring(j, j + i);
                    // System.out.println("sub " + sub);
                    
                } else {
                    sub = s.substring(j);
                    // System.out.println("sub2 " + sub);
                }
                
                // 이전 문자열과 같은지
                if(prevStr.equals(sub)) {
                    count++;
                    
                } else {
                    if(count > 1) {
                        sb.append(count);
                    }
                    
                    sb.append(prevStr);
                    prevStr = sub;
                    count = 1;
                }
            }
            
            if(count > 1) {
                sb.append(count);
            }
            sb.append(prevStr);
            
            // 작은 값
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}