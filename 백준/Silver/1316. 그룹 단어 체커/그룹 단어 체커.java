import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        // 이 단어가 연속해서 오는 단어 인지? 새로운 단어인지?
        // 새로운 단어라면, 이전에 나온 적이 있는지?

        for(int i = 0; i < N; i++) {
            String str = br.readLine(); // 문자열 입력

            if (check(str)) {
                count++;
            }
        }

        System.out.println(count);

    }

    public static boolean check(String str) {
        boolean[] check = new boolean[26]; // 연속해서 오는 단어인가? (알파벳 아스키코드 배열)
        int prev = 0; // 이전에 등장한 적 있는지?

        for(int j = 0; j < str.length(); j++) {
            int now = str.charAt(j); // 현재 문자의 아스키코드

            if (prev != now) { // 바로 전에 등장 안했고
                if (!check[now - 'a']) { // 더 전에도 아예 등장한 적 없다면
                    check[now - 'a'] = true; // 등장 표시
                    prev = now; // 등장 표시2
                }
                else { // 등장
                    return false;
                }
            }
        }

        return true;
    }
}