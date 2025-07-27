import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken()); // 목표 고객 수
        int N = Integer.parseInt(st.nextToken()); // 도시 개수

        int[] cost = new int[N]; // 홍보 비용
        int[] customer = new int[N]; // 홍보 후 고객 증가 수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            customer[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] = i명의 고객을 확보하기 위한 최소 비용
        int INF = 100000; // 초기값은 매우 큰 값(INF)으로 설정 (최소값을 찾기 위해)
        int[] dp = new int[C + 101]; // C 이상을 고려하기 위해 C+100까지 공간 확보
        Arrays.fill(dp, INF); // dp 배열 INF로 초기화
        dp[0] = 0; // 0명의 고객을 확보하는 데 필요한 비용은 0원

        for (int i = 1; i < dp.length; i++) { // 확보 고객 수 i
            for (int j = 0; j < N; j++) { // 홍보할 도시 j
                if (i - customer[j] >= 0) { // 현재 고객 수 i에서 홍보 후 고객 수를 뺀 값이 0 이상일 때만 갱신 가능
                     // 기존 dp[i] vs (i - customer[j])명의 고객을 확보 후 도시 j를 한 번 더 사용하는 경우
                    dp[i] = Math.min(dp[i], dp[i - customer[j]] + cost[j]);
                }
            }
        }

        // C명 이상 확보한 경우 중 최소 비용 찾기
        int result = INF;
        for (int i = C; i < dp.length; i++) { // C 이상 고객 확보 가능한 모든 경우 중
            result = Math.min(result, dp[i]); // 최소 비용을 선택
        }

        System.out.println(result);
    }
}
