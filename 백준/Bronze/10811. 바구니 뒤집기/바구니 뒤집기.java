import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] basket = new int[N];
        int[] reverse = new int[N];

        for(int i = 0; i < N; i++) {
            basket[i] = i+1;
            reverse[i] = i+1;
        }

        for(int k = 0; k < M; k++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st2.nextToken()) - 1;
            int j = Integer.parseInt(st2.nextToken()) - 1;
            int cnt = i;

            for(int l = j; l >= i; l--) {
                reverse[cnt++] = basket[l];
            }

            for(int l = 0; l < basket.length; l++) {
                basket[l] = reverse[l];
            }

        }

        for(int i : basket) {
            System.out.print(i + " ");
        }
        bw.flush();
        bw.close();
    }
}