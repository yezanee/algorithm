import java.util.*;
import java.io.*;

public class Main {

    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static int u, v; // 간선의 양 끝점
    static ArrayList<Integer>[] connect;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        connect = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            connect[i] = new ArrayList<>();
            visited[i] = false;
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            connect[u].add(v);
            connect[v].add(u);
        }

        result = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;

            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;

        while(!stack.isEmpty()) {
            int current = stack.pop();
            for (int neighbor : connect[current]) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}