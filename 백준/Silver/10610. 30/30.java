import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = charArr.length-1; i >= 0; i--) {
            int num = charArr[i] - '0';
            sum += num;
            sb.append(num);
        }
        
        if (charArr[0] != '0' || sum % 3 != 0) {
            System.out.println("-1");
            return;
        }
        
        System.out.println(sb);
        
    }
}