import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 시그널의 길이
        String str = br.readLine(); // 시그널 입력 받기

        int colLength = n / 5; // 한 숫자가 차지하는 열의 개수
        char[][] signal = new char[5][colLength]; // 시그널 배열

        for (int i = 0; i < 5; i++) { // 행
            for (int j = 0; j < colLength; j++) { // 열
                signal[i][j] = str.charAt(i * colLength + j);
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;

        while (index < colLength) {
            if (signal[0][index] == '#') {
                if (index + 2 < colLength && signal[0][index + 1] == '#' && signal[0][index + 2] == '#') {
                    // 0, 2, 3, 5, 6, 7, 8, 9
                    sb.append(converter(index, signal));
                    index += 3;
                    continue;
                } else if (signal[4][index] == '#') {
                    // 숫자 1
                    sb.append("1");
                    index += 1;
                } else {
                    // 숫자 4
                    sb.append("4");
                    index += 3;
                }
            } else {
                index++;
            }
        }

        System.out.println(sb.toString());
    }

    private static int converter(int index, char[][] signal) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(signal[i][j + index]);
            }
        }

        String pattern = sb.toString();
        switch (pattern) {
            case "####.##.##.####":
                return 0;
            case "###..#####..###":
                return 2;
            case "###..####..####":
                return 3;
            case "####..###..####":
                return 5;
            case "####..####.####":
                return 6;
            case "###..#..#..#..#":
                return 7;
            case "####.#####.####":
                return 8;
            case "####.####..####":
                return 9;
            default:
                return -1;
        }
    }
}
