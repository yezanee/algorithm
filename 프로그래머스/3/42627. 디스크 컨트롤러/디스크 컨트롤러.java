import java.util.*;

class Node {
    int costTime;
    int reqTime;
    int num;
    
    Node (int costTime, int reqTime, int num) {
        this.costTime = costTime;
        this.reqTime = reqTime;
        this.num = num;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int[] answer = new int[jobs.length];
        int nowTime = 0;
        int count = 0;
        int index = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.costTime == b.costTime) {
                    if (a.num == b.num) {
                        return a.num - b.num;
                    }
                    return a.reqTime - b.reqTime;
                }
                return a.costTime - b.costTime;
            }
        );
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        while (count < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= nowTime) {
                pq.add(new Node(jobs[index][1], jobs[index][0], index));
                index++;
            }
            
            if(pq.isEmpty()) {
               nowTime = jobs[index][0];
            }
            
            if(!pq.isEmpty()) {
                Node now = pq.poll();
                int nowCostTime = now.costTime;
                int nowReqTime = now.reqTime;
                int nowNum = now.num;
                
                nowTime += nowCostTime;
                answer[nowNum] = nowTime - nowReqTime;
                count++;
            }
        }
    
        
        int sum = 0;
        for(int i : answer) {
            sum += i;
        }
        

        return sum / answer.length;
    }
}