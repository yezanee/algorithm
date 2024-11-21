import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            if(str.length() == 1) {

                for(int j = 0; j < R; j++) {
                    bw.write(str.charAt(0));
                }

                bw.write("\n");

            } else {

                for(int j = 0; j < str.length() - 1; j++) {
                    char m = str.charAt(j);
                    for(int k = 0; k < R; k++) {
                        bw.write(m);
                    }
                }

                char m = str.charAt(str.length()-1);

                for(int k = 0; k < R; k++) {
                    bw.write(m);
                }

                bw.write("\n");

            }
        }

        bw.flush();
        bw.close();
    }
}