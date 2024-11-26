import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == 'c') {
                if (i < input.length() - 1 && (input.charAt(i + 1) == '=' || input.charAt(i + 1) == '-')) {
                    // 다음 문자가 '=' 또는 '-'인지 확인
                    i++;
                }
            } else if (ch == 'd') {
                if (i < input.length() - 2 && input.charAt(i + 1) == 'z' && input.charAt(i + 2) == '=') {
                    // 다음 문자들이 'z=' 인지 확인
                    i += 2;
                } else if (i < input.length() - 1 && input.charAt(i + 1) == '-') {
                    // 다음 문자가 '-'인지 확인
                    i++;
                }
            } else if (ch == 'l') {
                if (i < input.length() - 1 && input.charAt(i + 1) == 'j') {
                    // 다음 문자가 'j'인지 확인
                    i++;
                }
            } else if (ch == 'n') {
                if (i < input.length() - 1 && input.charAt(i + 1) == 'j') {
                    // 다음 문자가 'j'인지 확인
                    i++;
                }
            } else if (ch == 's') {
                if (i < input.length() - 1 && input.charAt(i + 1) == '=') {
                    // 다음 문자가 '='인지 확인
                    i++;
                }
            } else if (ch == 'z') {
                if (i < input.length() - 1 && input.charAt(i + 1) == '=') {
                    // 다음 문자가 '='인지 확인
                    i++;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}