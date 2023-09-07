import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        
        // 종료 시간 우선순위 큐
        PriorityQueue<Integer> endTimePq = new PriorityQueue<>();
        
        for(String[] time : book_time) {
            int start = convertTime(time[0]);
            int end = convertTime(time[1]);
            
            // 객실 재사용
            if(!endTimePq.isEmpty() && endTimePq.peek() <= start - 10) {
                endTimePq.poll();
            }
            
            // 현재의 예약 종료시간 추가
            endTimePq.add(end);
        }
        
        return endTimePq.size();
    }
    
    // 시간 분으로 변환
    private int convertTime(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        
        return (hour * 60) + minute;
    }
}