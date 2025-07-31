import java.util.*;
import java.io.*;

class Main {
    static class Jewel {
        long weight;
        long price;
        Jewel(long w, long p) {
            this.weight = w;
            this.price = p;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 보석의 총 개수
        int K = Integer.parseInt(st.nextToken()); // 상덕이의 가방 개수

        // 보석 정보 저장
        Jewel[] jewels = new Jewel[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long M = Long.parseLong(st.nextToken()); // 각 보석의 무게
            long V = Long.parseLong(st.nextToken()); // 각 보석의 가격
            jewels[i] = new Jewel(M, V);
        }
        
        // 가방 정보 저장
        long[] bags = new long[K];
        for(int i = 0; i < K; i++) {
            bags[i] = Long.parseLong(br.readLine()); // 각 가방에 보석을 담을 수 있는 최대 무게
        }

        // 1. 보석을 무게 기준으로 오름차순 정렬 -> 현재 가방 용량 이하의 보석만 힙에 추가하기 위해(무게 제한으로 선택 가능한 보석이 결정됨)
        // - 작은 가방 -> 작은 무게 보석부터 순서대로 확인 가능
        // - 한번 확인한 보석은 다음 가방에도 다시 볼 필요 없이 계속 유지 가능
        Arrays.sort(jewels, (a, b) -> Long.compare(a.weight, b.weight));
        
        // 2. 가방도 무게 기준으로 오름차순 정렬
        Arrays.sort(bags);

        // 최대 힙 (가격 기준) -> 우리는 보석 중 가장 가격이 비싼 것을 빠르게 꺼내야 함!
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위가 높은 것 먼저 나오는 큐(기본이 최소 힙이기 때문에 Collections.reverseOrder()로 우선순위 반대로 변경!)

        long totalPrice = 0;
        int jewelIndex = 0;

        // 3. 가방 순회
        for (long bacCapacity : bags) {
            // 현재 가방이 수용할 수 있는 보석들을 힙에 추가
            while (jewelIndex < N && jewels[jewelIndex].weight <= bacCapacity) {
                maxHeap.offer(jewels[jewelIndex].price); // 우선순위 큐에 추가
                jewelIndex++;
            }

            // 4. 힙에서 가장 비싼 보석 선택
            if (!maxHeap.isEmpty()) {
                totalPrice += maxHeap.poll();
            }
        }

        System.out.println(totalPrice);
    }
}