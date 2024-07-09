import java.io.*;

public class Main {   
    static int n; // 첫 번째 장대에 쌓인 원판의 개수
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        
        bw.write((int)(Math.pow(2, n) - 1) + "\n"); // 총 이동 횟수 출력
        hanoi(n, 1, 2, 3); // 1번 장대에서 3번 장대로 이동 목표
        
        bw.flush();
        bw.close();
    }
    
    // 하노이 탑 알고리즘
    public static void hanoi(int n, int from, int by, int to) throws IOException {
        if (n == 1) {
            bw.write(from + " " + to + "\n");
            return;
        }
        
        // n-1개의 원판을 from에서 to를 거쳐 by로 이동 (1 -> 2)
        hanoi(n - 1, from, to, by);
        // 가장 큰 원판을 from에서 to로 이동 (1 -> 3)
        bw.write(from + " " + to + "\n");
        // n-1개의 원판을 by에서 to로 이동 (2 -> 3)
        hanoi(n - 1, by, from, to);
    }
}
