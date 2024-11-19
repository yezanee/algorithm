import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] isSubmit = new boolean[31];

        for (int i = 0; i < 28; i++) {
            int num = Integer.parseInt(br.readLine());
            isSubmit[num] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if(!isSubmit[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();

    }
}