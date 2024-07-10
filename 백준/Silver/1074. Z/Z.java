import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력을 공백 기준으로 나누기 위해 StringTokenizer 사용
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        // 2^n 크기의 배열 크기 계산
        int size = (int)Math.pow(2, n);
        // Z 순회 순서 계산
        findZOrder(0, 0, size);
        // 결과 출력
        System.out.println(count);
    }
    
    // Z 순회 순서를 재귀적으로 찾는 메서드
    public static void findZOrder(int row, int col, int size) {
        // 기본 크기인 1x1에 도달하면 종료
        if (size == 1) {
            return;
        }
        
        // 현재 크기의 절반 계산
        int newSize = size / 2;
        // 각 사분면의 크기 계산
        int area = newSize * newSize;
        
        // 1사분면: 좌표가 (row, col)에서 시작하는 경우
        if (r < row + newSize && c < col + newSize) {
            findZOrder(row, col, newSize);
        }
        // 2사분면: 좌표가 (row, col + newSize)에서 시작하는 경우
        else if (r < row + newSize && c >= col + newSize) {
            count += area;
            findZOrder(row, col + newSize, newSize);
        }
        // 3사분면: 좌표가 (row + newSize, col)에서 시작하는 경우
        else if (r >= row + newSize && c < col + newSize) {
            count += 2 * area;
            findZOrder(row + newSize, col, newSize);
        }
        // 4사분면: 좌표가 (row + newSize, col + newSize)에서 시작하는 경우
        else {
            count += 3 * area;
            findZOrder(row + newSize, col + newSize, newSize);
        }
    }
}
