import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main
{
    public static int N; // 정점의 개수
    public static int V; // 간선의 개수
    public static int M; // 탐색을 시작할 정점의 번호
    public static int[][] adj;
    public static boolean[] visited;
    public static Queue<Integer> queue;
    
    public static void DFS(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 1; i <= N; i++) {
            if (adj[start][i] == 1 && visited[i] == false) {
                DFS(i);
            }
        }
    }
    
    public static void BFS(int start) {
        queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true;
        System.out.print(start + " ");
        
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            
            for (int i = 1; i < adj.length; i++) {
                if (adj[temp][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt(); // 정점의 개수
		M = in.nextInt(); // 간선의 개수
		V = in.nextInt(); // 탐색을 시작할 정점의 번호
		adj = new int[1001][1001];
		visited = new boolean[1001];
		
		for(int i = 0; i < M; i++) {
		    int a = in.nextInt();
		    int b = in.nextInt();
		    adj[a][b] = adj[b][a] = 1;
		}
		
		DFS(V);
		System.out.println();
		
		Arrays.fill(visited, false);
		BFS(V);
	}
}