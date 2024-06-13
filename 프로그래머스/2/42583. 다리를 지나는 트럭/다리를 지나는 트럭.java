import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 내부 클래스로 Truck 정의: 각 트럭의 무게와 다리를 빠져나가는 시간을 관리
    class Truck {
        int weight;      // 트럭의 무게
        int exitTime;    // 트럭이 다리에서 나가는 시간

        // Truck 객체 생성자
        public Truck(int weight, int exitTime) {
            this.weight = weight;
            this.exitTime = exitTime;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0; // 시간을 0부터 시작
        int bridge_weight = 0; // 다리 위의 트럭 총 무게 초기화
        Queue<Truck> bridge = new LinkedList<>(); // 다리 위에 있는 트럭을 관리할 큐
        Queue<Integer> trucksWaiting = new LinkedList<>(); // 대기 중인 트럭의 무게를 관리할 큐

        // 대기 큐에 초기 트럭 무게들을 추가
        for (int truckWeight : truck_weights) {
            trucksWaiting.add(truckWeight);
        }

        // 모든 트럭이 다리를 건너고 다리가 비어질 때까지 반복
        while (!trucksWaiting.isEmpty() || !bridge.isEmpty()) {
            time++; // 시간을 1씩 증가

            // 다리 위에 있는 트럭 중에서 다리를 빠져나갈 시간이 된 트럭이 있는지 확인
            if (!bridge.isEmpty() && bridge.peek().exitTime == time) {
                Truck exitingTruck = bridge.poll(); // 다리에서 트럭을 제거
                bridge_weight -= exitingTruck.weight; // 다리의 총 무게에서 제거된 트럭의 무게를 빼줌
            }

            // 다음 트럭이 다리에 올라갈 수 있는지 검사: 다리의 무게 제한과 길이 제한을 모두 고려
            if (!trucksWaiting.isEmpty() &&
                bridge_weight + trucksWaiting.peek() <= weight &&
                bridge.size() < bridge_length) {

                int nextTruckWeight = trucksWaiting.poll(); // 다리에 올릴 트럭을 대기 큐에서 제거
                bridge.add(new Truck(nextTruckWeight, time + bridge_length)); // 새 트럭을 다리 큐에 추가
                bridge_weight += nextTruckWeight; // 다리 위의 총 무게를 업데이트
            }
        }

        return time; // 모든 트럭이 다리를 건넌 후의 총 시간 반환
    }
}