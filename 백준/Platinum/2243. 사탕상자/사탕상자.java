import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 1_000_000;
    static long[] tree = new long[MAX * 4];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수정이가 사탕상자에 손을 댄 횟수

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 명령문

            if (A == 1) { // 사탕 상자에서 사탕을 꺼내는 경우(개수: 1개)
                long B = Long.parseLong(st.nextToken()); // 꺼낼 사탕의 맛 순위
                long flavor = findCandy(1, 1, MAX, B); // B번째 사탕 맛 찾기
                bw.write(flavor + "\n");
                update(1, 1, MAX, flavor, -1); // 사탕 1개 감소
            }
            
            else if (A == 2) { // 사탕 상자에 사탕을 넣는 경우
                long B = Long.parseLong(st.nextToken()); // 넣을 사탕의 맛 순위
                long C = Long.parseLong(st.nextToken()); // 넣을 사탕의 개수(양수: 넣는 경우, 음수: 빼는 경우)
            
                update(1, 1, MAX, B, C); // 맛 B 사탕 개수 C만큼 변경
            }  
        }

        bw.flush();
    }
    
    // 트리 업데이트 (사탕 + 또는 -)
    static void update(int node, int start, int end, long idx, long diff) {
        if (idx < start || idx > end) return; // 범위 벗어나면 종료
        tree[node] += diff; // 사탕 값 변경
            
        if (start != end) { // 리프 노드가 아니라면 자식 호출
            int mid = (start + end) / 2;
            update(node * 2, start, mid, idx, diff);
            update(node * 2 + 1, mid + 1, end, idx, diff);
        }
    }

    // B번째 사탕 찾기
    static int findCandy(int node, int start, int end, long rank) {
        if (start == end) return start;  // 리프 도착 -> 맛 순위 반환
            
        int mid = (start + end) / 2;
    
        if (tree[node * 2] >= rank) {
            return findCandy(node * 2, start, mid, rank);
        } else {
            return findCandy(node * 2 + 1, mid + 1, end, rank - tree[node * 2]);
            // 왼쪽 자식 노드 건너뛰고 오른쪽 자식노드 순위 계산 (위치에 따른 순위 탐색)
        }
    }
}
