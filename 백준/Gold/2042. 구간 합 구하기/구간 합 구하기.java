import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static long[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 배열 크기
        M = Integer.parseInt(st.nextToken()); // 값 변경 횟수
        K = Integer.parseInt(st.nextToken()); // 구간 합 구하는 횟수

        arr = new long[N]; // 입력 값을 저장할 배열
        tree = new long[N * 4]; // 세그먼트 트리는 보통 4배 크기 할당

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 세그먼트 트리 초기화 (구간 합을 미리 계산해서 트리에 저장)
        init(1, 0, N - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 연산 종류 (1: 값 변경, 2: 구간합) 
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                // 값 변경 (b번째 수를 c로 변경)
                update(1, 0, N - 1, b - 1, c - arr[b - 1]); // 변경된 값의 차이만큼 갱신
                arr[b - 1] = c; // 원본 배열도 갱신
            } else if (a == 2) {
                // 구간 합 출력 (b번째~c번째 구간합)
                long result = sum(1, 0, N - 1, b - 1, (int)c - 1);
                bw.write(result + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 세그먼트 트리 초기화
    static long init(int node, int start, int end) { // node: 현재 세그먼트 트리의 노드 번호, start: 현재 구간의 시작 인덱스, end: 현재 구간의 끝 인덱스
        if (start == end) { // 리프 노드인 경우
            return tree[node] = arr[start]; // 리프 노드인 경우 배열의 값을 그대로 저장
        }
        int mid = (start + end) / 2; // 중간 인덱스
        return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end); // 왼쪽 자식 노드와 오른쪽 자식 노드의 합을 저장
    }

    // 특정 구간 합 구하기
    static long sum(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            // 구간이 완전히 벗어난 경우
            return 0;
        }
        if (left <= start && end <= right) {
            // 구간이 완전히 포함된 경우
            return tree[node];
        }

        // 왼쪽 자식 노드와 오른쪽 자식 노드의 합을 저장
        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, left, right) + // 왼쪽 자식 노드의 합
               sum(node * 2 + 1, mid + 1, end, left, right); // 오른쪽 자식 노드의 합
    }

    // 특정 원소 값 갱신
    static void update(int node, int start, int end, int index, long diff) {
        if (index < start || index > end) {
            return; // 인덱스가 현재 구간에 포함되지 않음
        }
        tree[node] += diff; // 현재 노드 값 갱신
        if (start != end) { // 리프 노드가 아닌 경우
            int mid = (start + end) / 2; // 중간 인덱스
            update(node * 2, start, mid, index, diff); // 왼쪽 자식 노드 갱신
            update(node * 2 + 1, mid + 1, end, index, diff); // 오른쪽 자식 노드 갱신
        }
    }
}
