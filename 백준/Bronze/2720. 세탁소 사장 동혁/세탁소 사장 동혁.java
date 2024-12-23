import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = sc.nextInt();
        int quarter, dime, nickel, penny;

        for(int i = 0; i < T; i++) {
            int input = sc.nextInt();

            quarter = input > 0 ? input / 25 : 0;
            input = input > 0 && quarter > 0 ? input % (25 * quarter) : input;
            dime = input > 0 ? input / 10 : 0;
            input = input > 0 && dime > 0 ? input % (10 * dime) : input;
            nickel = input > 0 ? input / 5 : 0;
            input = input > 0 && nickel > 0 ? input % (5 * nickel) : input;
            penny = input;

            bw.write(quarter + " " + dime + " " + nickel + " " + penny + "\n");
        }

        bw.flush();
        bw.close();
    }

}