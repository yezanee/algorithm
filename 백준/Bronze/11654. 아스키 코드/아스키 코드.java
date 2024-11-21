import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char input = br.readLine().charAt(0);
        int result = (int)input;
        
        // BufferedWriter를 이용할 시엔 String으로만 출력
        System.out.println(result);

    }
}