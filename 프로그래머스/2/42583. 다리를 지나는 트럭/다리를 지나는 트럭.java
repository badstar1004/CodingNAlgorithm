import java.util.*;

class Truck {
    int weight;
    int distanceLeft;

    public Truck(int weight, int distanceLeft) {
        this.weight = weight;
        this.distanceLeft = distanceLeft;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
         Queue<Truck> bridge = new LinkedList<>();
        int time = 0;
        int totalWeightOnBridge = 0;
        int index = 0;

        while (index < truck_weights.length || !bridge.isEmpty()) {
            time++;

            // 다리 위의 트럭이 다리를 건너면 다리에서 제거
            if (!bridge.isEmpty() && bridge.peek().distanceLeft <= 0) {
                totalWeightOnBridge -= bridge.poll().weight;
            }

            // 새 트럭이 다리에 진입할 수 있는지 확인
            if (index < truck_weights.length && totalWeightOnBridge + truck_weights[index] <= weight) {
                Truck truck = new Truck(truck_weights[index], bridge_length);
                bridge.add(truck);
                totalWeightOnBridge += truck.weight;
                index++;
            }

            // 다리 위의 모든 트럭의 남은 거리 업데이트
            for (Truck t : bridge) {
                t.distanceLeft--;
            }
        }

        return time;
    }
}