import java.util.*;

class Solution {
    
    // HH:MM:SS -> SS
    private static int timeToSeconds(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 3600
            + Integer.parseInt(split[1]) * 60 + Integer.parseInt(split[2]);
    }
    
    private static String secondsToTime(long seconds) {
        long hour = seconds / 3600;
        seconds %= 3600;
        
        long minutes = seconds / 60;
        seconds %= 60;
        
        return String.format("%02d:%02d:%02d", hour, minutes, seconds);
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        int playTime = timeToSeconds(play_time);
        int advTime = timeToSeconds(adv_time);
        
        // 누적합
        long[] prefixSum = new long[playTime + 1];
        
        // 시청자 수
        for(String log : logs) {
            String[] split = log.split("-");
            int start = timeToSeconds(split[0]);
            int end = timeToSeconds(split[1]);
            
            prefixSum[start] += 1;
            prefixSum[end] -= 1;
        }
        
        // 누적 재생 횟수 계산
        for(int i = 1; i <= playTime; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
        
        // 누적 재생 시간 계산
        for(int i = 1; i <= playTime; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
        
        // 광고 삽입
        long maxTime = prefixSum[advTime - 1];
        long startTime = 0;
        for (int i = 0; i + advTime <= playTime; i++) {
            long endTime = i + advTime;
            long totalTime = prefixSum[(int) endTime] - prefixSum[i];
            
            if (totalTime > maxTime) {
                maxTime = totalTime;
                startTime = i + 1;
            }
        }
        
        return secondsToTime(startTime);
    }
}