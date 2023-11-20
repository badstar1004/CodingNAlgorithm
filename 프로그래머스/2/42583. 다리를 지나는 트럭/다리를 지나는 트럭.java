import java.util.*;

class Truck {
    int weight;     // 무게
    int remainDistance;     // 남아있는 거리

    public Truck(int weight, int remainDistance) {
        this.weight = weight;
        this.remainDistance = remainDistance;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Truck> bridge = new LinkedList<>();
        int time = 0;
        int totalWeightOnBridge = 0;
        int index = 0;

        while (!bridge.isEmpty() || index < truck_weights.length) {
            time++;

            // 다리 위의 트럭이 다리를 건너면 다리에서 제거
            if (!bridge.isEmpty() && bridge.peek().remainDistance <= 0) {
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
                t.remainDistance--;
            }
        }

        return time;
    }
}