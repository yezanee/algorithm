import java.util.*;

class Solution {
    
    static class Truck {
        int weight;
        int exitTime;
        
        Truck(int weight, int exitTime) {
            this.weight = weight;
            this.exitTime = exitTime;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int proIndex = 0;
        int comIndex = 0;
        int currentWeight = 0;
        
        Queue<Truck> bridgeProgression = new LinkedList<>();
        
        while(comIndex < truck_weights.length) {
            time++;
            
            // 1. 나갈 트럭 체크 (시간 기반)
            if(!bridgeProgression.isEmpty() && 
               bridgeProgression.peek().exitTime == time) {
                Truck t = bridgeProgression.poll();
                currentWeight -= t.weight;
                comIndex++;
            }
            
            // 2. 새 트럭 올리기
            if(proIndex < truck_weights.length &&
               currentWeight + truck_weights[proIndex] <= weight &&
               bridgeProgression.size() < bridge_length) {
                
                int exitTime = time + bridge_length;
                bridgeProgression.add(new Truck(truck_weights[proIndex], exitTime));
                
                currentWeight += truck_weights[proIndex];
                proIndex++;
            }
        }
        
        return time;
    }
}