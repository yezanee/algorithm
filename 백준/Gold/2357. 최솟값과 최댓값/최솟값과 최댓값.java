import java.util.*;
import java.io.*;

class Main {
    
    static int[] numbers;
    static int[] minTree;
    static int[] maxTree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 정수의 개수
        int M = Integer.parseInt(st.nextToken()); // a, b의 쌍의 개수
        
        numbers = new int[N]; // 정수 배열
        minTree = new int[N*4];
        maxTree = new int[N*4];

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        
        // 세그먼트 트리 초기화
        initMinTree(1, 0, N - 1); // 루트 노드, 현재 노드가 담당하는 구간의 시작, 끝
        initMaxTree(1, 0, N - 1); // 루트 노드, 현재 노드가 담당하는 구간의 시작, 끝

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

						int min = queryMin(1, 0, N - 1, a, b);
            int max = queryMax(1, 0, N - 1, a, b);
            
            bw.write(min + " " + max + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 최솟값 트리 초기화
    static int initMinTree(int node, int start, int end) {
        if (start == end) { // 현재 구간이 단일 원소일 때 -> 배열 값 저장
            return minTree[node] = numbers[start];
        }
        int mid = (start + end) / 2;
        return minTree[node] = Math.min( // 두 자식 구간의 최소값 중 작은 값 저장
            initMinTree(node * 2, start, mid), // 왼쪽 자식
            initMinTree(node * 2 + 1, mid + 1, end) // 오른쪽 자식
        );
    }

    // 최댓값 트리 초기화
    static int initMaxTree(int node, int start, int end) {
        if (start == end) { // 현재 구간이 단일 원소일 때 -> 배열 값 저장
            return maxTree[node] = numbers[start];
        }
        int mid = (start + end) / 2;
        return maxTree[node] = Math.max( // 두 자식 구간의 최댓값 중 큰 값 저장
            initMaxTree(node * 2, start, mid), // 왼쪽 자식
            initMaxTree(node * 2 + 1, mid + 1, end) // 오른쪽 자식
        );
    }

    // 구간 최솟값 쿼리
    static int queryMin(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return Integer.MAX_VALUE; // 구간 벗어남
        if (left <= start && end <= right) return minTree[node]; // 완전히 포함
        int mid = (start + end) / 2;
        return Math.min(
            queryMin(node * 2, start, mid, left, right), // 왼쪽
            queryMin(node * 2 + 1, mid + 1, end, left, right) // 오른쪽
        );
    }

    // 구간 최댓값 쿼리
    static int queryMax(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return Integer.MIN_VALUE; // 구간 벗어남
        if (left <= start && end <= right) return maxTree[node]; // 완전히 포함
        int mid = (start + end) / 2;
        return Math.max(
            queryMax(node * 2, start, mid, left, right),
            queryMax(node * 2 + 1, mid + 1, end, left, right)
        );
    }
}