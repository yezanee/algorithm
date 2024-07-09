import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] paper;
    static int[] cnt = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideAndConquer(0, 0, n);

        for (int i = 0; i < 3; i++) {
            System.out.println(cnt[i]);
        }
    }

    public static void divideAndConquer(int row, int col, int size) {
        if (checkUniform(row, col, size)) {
            cnt[paper[row][col] + 1]++;
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divideAndConquer(row + i * newSize, col + j * newSize, newSize);
            }
        }
    }

    public static boolean checkUniform(int row, int col, int size) {
        int firstValue = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != firstValue) {
                    return false;
                }
            }
        }
        return true;
    }
}