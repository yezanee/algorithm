import java.util.*;
import java.io.*;

public class Main
{
    static int n; // 영상의 크기
    static char[][] QuadTree;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		QuadTree = new char[n][n];
		for(int i = 0; i < n; i++) {
		    String line = br.readLine();
		    for(int j = 0; j < n; j++) {
		        QuadTree[i][j] = line.charAt(j);
		    }
		}
		
		compress(0, 0, n); // 압축 시작
		System.out.println(sb.toString());
		
	}
	
	// 압축 (시작위치(x, y)와 크기 매개변수로 ..)
	public static void compress(int x, int y, int size) {
        if(isSame(x, y, size)) { // 주어진 영역이 모두 동일한가?
            sb.append(QuadTree[x][y]); // 동일한 값이면 해당 값 결과에 추가
            return; // 함수 종료
        }
        
        int newSize = size / 2;
        
        sb.append('(');
        compress(x, y, newSize);           // 1사분면
        compress(x, y + newSize, newSize); // 2사분면
        compress(x + newSize, y, newSize); // 3사분면
        compress(x + newSize, y + newSize, newSize); // 4사분면
        sb.append(')');
    }
    
    // 주어진 영역이 모두 동일한 값을 가지는 지 검사
    public static boolean isSame(int x, int y, int size) {
        char value = QuadTree[x][y]; // 비교할 첫번째 값 저장
        
        for(int i = x; i < x + size; i++) { // 주어진 영역의 모든 값 돌기
            for(int j = y; j < y + size; j++) {
                if(QuadTree[i][j] != value) { // 하나라도 다르면 false
                    return false;
                }
            }
        }
        
        return true; // 모두 같으면 true
    }
}