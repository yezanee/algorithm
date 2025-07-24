import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;     // 실제 수열 값
    static int[] tree;    // 세그먼트 트리: 각 노드에 최솟값의 인덱스 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tree = new int[N * 4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(1, 0, N - 1);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                int value = Integer.parseInt(st.nextToken());
                arr[idx] = value;
                update(1, 0, N - 1, idx);
            } else {
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;
                int result = query(1, 0, N - 1, l, r);
                bw.write((result + 1) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static int init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = start;
        }

        int mid = (start + end) / 2;
        int leftIdx = init(node * 2, start, mid);
        int rightIdx = init(node * 2 + 1, mid + 1, end);

        if (arr[leftIdx] < arr[rightIdx]) return tree[node] = leftIdx;
        else if (arr[leftIdx] > arr[rightIdx]) return tree[node] = rightIdx;
        else return tree[node] = Math.min(leftIdx, rightIdx); // 값 같으면 인덱스 작은 것
    }

    static int update(int node, int start, int end, int idx) {
        if (idx < start || idx > end) return tree[node];

        if (start == end) {
            return tree[node] = idx;
        }

        int mid = (start + end) / 2;
        int leftIdx = update(node * 2, start, mid, idx);
        int rightIdx = update(node * 2 + 1, mid + 1, end, idx);

        if (arr[leftIdx] < arr[rightIdx]) return tree[node] = leftIdx;
        else if (arr[leftIdx] > arr[rightIdx]) return tree[node] = rightIdx;
        else return tree[node] = Math.min(leftIdx, rightIdx);
    }

    static int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return -1;

        if (l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2;
        int leftIdx = query(node * 2, start, mid, l, r);
        int rightIdx = query(node * 2 + 1, mid + 1, end, l, r);

        if (leftIdx == -1) return rightIdx;
        if (rightIdx == -1) return leftIdx;

        if (arr[leftIdx] < arr[rightIdx]) return leftIdx;
        else if (arr[leftIdx] > arr[rightIdx]) return rightIdx;
        else return Math.min(leftIdx, rightIdx);
    }
}
