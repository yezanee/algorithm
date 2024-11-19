import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken()); // 도현이가 가지고 있는 바구니 개수
        int M = Integer.parseInt(st.nextToken()); // 도현이가 공을 넣을 횟수
        int[] basket = new int[N];
        for(int i : basket) i = 0;
        int[][] method = new int[M][3];

        for(int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            method[i][0] = Integer.parseInt(st2.nextToken());
            method[i][1] = Integer.parseInt(st2.nextToken());
            method[i][2] = Integer.parseInt(st2.nextToken());

            for(int j = method[i][0]; j <= method[i][1]; j++) {
                basket[j-1] = method[i][2];
            }
        }

        for(int i : basket) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
    }
}