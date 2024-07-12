import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr;
    static int[] output;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 배열 크기
        m = Integer.parseInt(st.nextToken()); // 수열 길이

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 오름차순 정렬

        output = new int[m]; // 수열 저장 배열
        visited = new boolean[n]; // 방문 여부 저장 배열

        // 백트래킹을 통해 수열을 생성하고 결과를 sb에 저장
        sequence(0);
        System.out.print(sb.toString());
    }

    public static void sequence(int depth) {
        // 순열의 길이가 m이라면
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                // 순열 sb에 저장
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        int prev = -1; // 이전 숫자 저장 변수 (중복 제거 위해)
        for (int i = 0; i < n; i++) {
            // 이전에 사용한 숫자와 다르며, 방문하지 않은 숫자라면
            if (prev != arr[i] && !visited[i]) {
                output[depth] = arr[i];
                prev = arr[i]; // 이전 숫자 현재 숫자로 갱신
                visited[i] = true; // 현재 숫자 사용으로 표시
                
                // 다음 depth로 재귀 호출
                sequence(depth + 1);
                
                visited[i] = false; // 백트래킹: 숫자 사용 취소
            }
        }
    }
}

