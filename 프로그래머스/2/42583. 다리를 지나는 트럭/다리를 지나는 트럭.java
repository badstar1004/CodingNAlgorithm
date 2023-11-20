import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        int totalWeight = 0;
        int time = 0;
        
        for (int truck : truck_weights) {
            while (true) {
                // 다리가 비어있는 경우
                if (bridge.isEmpty()) {
                    bridge.add(truck);
                    totalWeight += truck;
                    time++;
                    break;
                }
                // 다리가 가득 찬 경우
                else if (bridge.size() == bridge_length) {
                    totalWeight -= bridge.poll();
                }
                // 다리에 여유가 있는 경우
                else {
                    // 다음 트럭이 올라갈 수 있는 경우
                    if (totalWeight + truck <= weight) {
                        bridge.add(truck);
                        totalWeight += truck;
                        time++;
                        break;
                    } 
                    // 다음 트럭이 올라갈 수 없는 경우
                    else {
                        bridge.add(0); // 무게 0인 가상의 트럭을 추가
                        time++;
                    }
                }
            }
        }
        
        // 마지막 트럭이 다리를 건너는 시간 추가
        return time + bridge_length;
    }
}