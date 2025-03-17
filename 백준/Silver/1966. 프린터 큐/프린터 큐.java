import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken()); // 문서 개수
      int M = Integer.parseInt(st.nextToken()); // 내가 궁금한 문서의 위치

      // 중요도를 저장하는 큐
      Queue<int[]> queue = new LinkedList<>();
      // 우선순위 정렬을 위한 리스트
      PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); 

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int importance = Integer.parseInt(st.nextToken());
        queue.offer(new int[]{j, importance}); // 문서 위치, 중요도 저장
        priorityQueue.offer(importance); // 우선순위 큐에도 추가 (최대값 기준 정렬)
      }

      int count = 0; // 출력된 문서 개수

      while (!queue.isEmpty()) {
        int[] current = queue.poll(); // 큐의 맨 앞 문서를 꺼냄

        // 현재 문서가 가장 높은 중요도를 가진 문서인지 확인
        if (current[1] == priorityQueue.peek()) {
          count++;
          priorityQueue.poll();
            
          // 찾던 문서면 결과 저장 후 종료
          if (current[0] == M) {
            sb.append(count).append("\n");
            break;
          }
            
        } else {
          queue.offer(current); // 중요도가 낮으면 다시 큐에 추가
        }
      }
    }
    System.out.print(sb.toString());
  }
}

