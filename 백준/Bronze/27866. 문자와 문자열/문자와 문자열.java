import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int N = Integer.parseInt(br.readLine());

        char result = S.charAt(N-1); // charAt은 특정 위치의 문자를 리턴한다.

        System.out.println(result);
    }
}