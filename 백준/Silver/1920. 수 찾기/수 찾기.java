import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        int[] nums = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            int start = 0;
            int end = N-1;
            int pivot = (start + end) / 2;
            
            while(start <= end) {
                pivot = (start + end) / 2;
                if (A[pivot] == nums[i]) {
                    sb.append(1+"\n");   
                    break;
                }
                else if (A[pivot] > nums[i]) end = pivot-1;
                else start = pivot+1;    
           }
           
            if(A[pivot] != nums[i]) sb.append(0+"\n");
       }
        
        System.out.println(sb.toString());
     
    }
}