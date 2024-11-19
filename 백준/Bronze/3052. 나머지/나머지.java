import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];
        int[] remain = new int[10];
        int result = 10;

        for(int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            remain[i] = arr[i] % 42;
        }

        Arrays.sort(remain);

        for(int i = 1; i < 10; i++) {
            if (remain[i-1] == remain[i]) {
                result--;
            }
        }
        
        System.out.println(result);
    }
}