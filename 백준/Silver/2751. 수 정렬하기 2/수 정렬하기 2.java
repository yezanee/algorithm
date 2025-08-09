import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nums);
        
        for(int i = 0; i < N; i++) {
            bw.write(nums[i] + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}