import java.util.*;

class Solution {
    
    private Map<Long, Long> nextRoomMap;
    
    
    public long[] solution(long k, long[] room_number) {
        nextRoomMap = new HashMap<>();
        long[] answer = new long[room_number.length];
        
        for(int i = 0; i < room_number.length; i++) {
            answer[i] = findNextRoom(room_number[i]);
        }
        
        return answer;
    }
    
    private long findNextRoom(long room) {
        // 이미 방이 배정 된 경우 다른 방 배정
        if(nextRoomMap.containsKey(room)) {
            long nextRoom = findNextRoom(nextRoomMap.get(room));
            nextRoomMap.put(room, nextRoom);
            return nextRoom;
            
        } else {
            // 비어있다면 방 배정 후 다음 방을 가리키도록 설정
            nextRoomMap.put(room, room + 1);
            return room;
        }
    }
}