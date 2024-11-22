import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int[] newNumArr1 = new int[3];
        int[] newNumArr2 = new int[3];

        for(int i = 0; i < 3; i++) {
            newNumArr1[i] = num1 % 10;
            newNumArr2[i] = num2 % 10;

            num1 /= 10;
            num2 /= 10;

        }

        int newNum1 = newNumArr1[0] * 100 + newNumArr1[1] * 10 + newNumArr1[2];
        int newNum2 = newNumArr2[0] * 100 + newNumArr2[1] * 10 + newNumArr2[2];

        System.out.println(newNum1 > newNum2 ? newNum1 : newNum2);
    }
}