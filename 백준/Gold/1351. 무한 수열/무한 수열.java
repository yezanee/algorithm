import java.util.*;
import java.io.*;

class Main {

    static long P, Q;
    static Map<Long, Long> memo = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        System.out.println(calc(N)); // 무한 수열 계산
        
    }

    static long calc(long n) {
        if (n == 0) return 1;
        if (memo.containsKey(n)) return memo.get(n); // 중복 재귀 호출 피함

        long value = calc(n / P) + calc(n / Q);
        memo.put(n, value);
        return value;
    }
}