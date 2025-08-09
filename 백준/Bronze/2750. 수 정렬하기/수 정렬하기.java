import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(num);
        
        for(int i=0; i<N; i++) {
            bw.write(num[i] + "\n");
        }
        
        bw.flush();
        bw.close();
        
    }
}