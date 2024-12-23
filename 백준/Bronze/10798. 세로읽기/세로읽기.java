import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = new String[5];
        int cnt = 0;

        for(int i = 0; i < 5; i++) {
            input[i] = br.readLine();
        }

        for(int j = 0; j < 15; j++) {
            for(int i = 0; i < 5; i++) {
                if(j < input[i].length()) {
                    System.out.print(input[i].charAt(j));
                }
            }
        }
    }
}