import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] friend;
	static boolean[] visited;
	static boolean found = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		friend = new ArrayList[N];
    visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			friend[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friend[a].add(b);
			friend[b].add(a);
		}
		
		for(int i=0; i<N; i++) {
			DFS(i, 1);
			if(found) break;
		}
		
		System.out.println(found ? 1 : 0);
	}
	
	static void DFS(int v, int depth) {
		if (found) return;
		if (depth == 5 || found) {
			found = true;
			return;
		}
		
		visited[v] = true;
		
		for(int i : friend[v]) {
			if (visited[i] == false) { // 연결 노드 중 방문하지 않았던 노드만 탐색하기
				  DFS(i, depth + 1);
			}
		}
		
		visited[v] = false;
	}
}