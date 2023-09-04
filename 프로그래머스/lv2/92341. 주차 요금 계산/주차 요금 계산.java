import java.util.*;

// 입출차 클래스
class CarInfo {
    // IN
    int inTime;
    // 전체 시간
    int totalTime;
    
    CarInfo(int inTime) {
        this.inTime = inTime;
        this.totalTime = 0;
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        // HashMap<차량번호, 입출차 클래스>
        HashMap<String, CarInfo> carHashMap = new HashMap<>();
        
        // 시간 계산
        for(String inOutInfo : records) {
            String[] info = inOutInfo.split(" ");
            
            int time = convertToMinutes(info[0]);
            String carNumber = info[1];
            String inOut = info[2];
            
            if (inOut.equals("IN")) {
                // 출차 후 다시 입차
                if(!carHashMap.containsKey(carNumber)) {
                    carHashMap.put(carNumber, new CarInfo(time));
                    
                } else {
                    carHashMap.get(carNumber).inTime = time;
                }
                
            } else {
                CarInfo carInfo = carHashMap.get(carNumber);
                // 주차시간
                int parkedTime = time - carInfo.inTime;
                carInfo.totalTime += parkedTime;
                carInfo.inTime = -1;
            }
        }
        
        // 일괄 정산
        for(Map.Entry<String, CarInfo> car : carHashMap.entrySet()) {
            CarInfo infoCar = car.getValue();
            
            if(infoCar.inTime != -1) {
                infoCar.totalTime += 1439 - infoCar.inTime;
            }
        }
        
        // 요금 계산
        // 차량번호 ArrayList 로 변환 후 정렬
        List<String> sortCars = new ArrayList<>(carHashMap.keySet());
        Collections.sort(sortCars);

        answer = new int[sortCars.size()];
        for (int i = 0; i < sortCars.size(); i++) {
            answer[i] = calFee(carHashMap.get(sortCars.get(i)).totalTime, fees);
        }
        
        return answer;
    }
    
    // 분 변환
    private int convertToMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    
    // 계산
    private int calFee(int totalTime, int[] fees) {
        if (totalTime <= fees[0]) {
            return fees[1];
        }
        return fees[1] + (int) Math.ceil((double) (totalTime - fees[0]) / fees[2]) * fees[3];
    }
}