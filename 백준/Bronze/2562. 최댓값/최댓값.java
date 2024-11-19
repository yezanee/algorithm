import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] intArr = new int[9];

        for(int i = 0; i < 9; i++) {
            intArr[i] = Integer.parseInt(br.readLine());
        }

        int max = intArr[0];
        int location = 1;

        for(int i = 1; i < 9; i++) {
            if (max < intArr[i]) {
                max = intArr[i];
                location = i+1;
            }
        }

        bw.write(max + "\n" + location);
        bw.flush();
        bw.close();

    }
}