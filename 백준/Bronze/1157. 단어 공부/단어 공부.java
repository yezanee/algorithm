import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        int[] cnt = new int[26]; // 알파벳 카운트를 위한 배열

        // 각 알파벳의 등장 횟수를 카운트
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'A']++;
        }

        int max = 0; // 최대값
        int result = -1; // 결과값

        // 최대값을 계산
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                result = i;
            } else if (cnt[i] == max) {
                result = -1; // 중복된 경우
            }
        }

        // 결과 출력
        if (result == -1) {
            System.out.println("?");
        } else {
            System.out.println((char) (result + 'A'));
        }
    }
}
