import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(!queue.isEmpty()) {
            for (int i = 0; i < K-1; i++) {
                queue.add(queue.remove());
            } // K-1번 만큼 큐 맨 앞의 요소를 제거하여 튜의 맨 뒤로 옮김.
            sb.append(queue.remove()); // K번째 요소를 완전히 제거하면서 결과 문자열에 추가.
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb.toString());
        in.close();
    }
    
}