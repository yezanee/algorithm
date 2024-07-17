import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int s = Integer.parseInt(st.nextToken()); // 크기
        String n = st.nextToken(); // 디스플레이에 나타내야 할 수
        
        // 각 숫자에 해당하는 세그먼트 디스플레이의 패턴 저장 배열
        // 각 문자는 해당 세그먼트가 켜져 있는 지를 나타냄 ('1' : on, '0' : off)
        String[] segments = {
            "1110111", // 0
            "0010010", // 1
            "1011101", // 2
            "1011011", // 3
            "0111010", // 4
            "1101011", // 5
            "1101111", // 6
            "1010010", // 7
            "1111111", // 8
            "1111011"  // 9
        };

        int height = 2 * s + 3; // 총 높이
        int width = s + 2; // 각 숫자의 폭

        StringBuilder[] sb = new StringBuilder[height];
        // 세그먼트 디스플레이는 여러 줄로 이루어져 있다.
        // 각 줄에 해당하는 문자열을 별도로 관리하기 위해 배열을 이용한다.
        // 마지막에 모두 결합
        
        for (int i = 0; i < height; i++) {
            sb[i] = new StringBuilder();
        }
        // 각 배열의 요소를 StringBuilder 객체로 초기화
        // 자바에서 객체 배열을 선언하면 배열 요소는 기본적으로 null로 초기화 되기 때문
        // NullPointerException 발생 방지
        
        // 각 숫자를 처리하고, 숫자 간에 공백을 추가
        for (int i = 0; i < n.length(); i++) {
            if (i > 0) { // 첫번째 숫자가 아닌 경우에만 실행
                for (int j = 0; j < height; j++) {
                    sb[j].append(" "); // 각 숫자 사이에 공백 추가
                }
            }
            String numSegment = segments[n.charAt(i) - '0'];
            // 현재 숫자를 변수로 변환
            appendNumber(sb, numSegment, s, width);
            // 현재 숫자를 디스플레이 형식으로 sb에 추가
        }

        for (StringBuilder row : sb) {
            System.out.println(row.toString());
        }
        // sb 배열에 저장된 각 줄을 출력
    }
    
    // 숫자를 세그먼트 디스플레이로 변환하여 sb 배열에 추가하는 함수
    static void appendNumber(StringBuilder[] sb, String numSegment, int s, int width) {
        for (int i = 0; i < sb.length; i++) { // 각 줄을 순회하며 세그먼트 추가
            
            // 상단
            if (i == 0) {
                sb[i].append(" "); // 줄 처음에 공백 추가
                for (int j = 0; j < s; j++) sb[i].append(numSegment.charAt(0) == '1' ? "-" : " ");
                // 상단 세그먼트가 켜져있는 지 확인하고,
                // 켜져 있으면 "-" 추가
                // 꺼져 있으면 " "(공백) 추가
                // 세그먼트의 길이 만큼 반복
                sb[i].append(" "); // 줄 마지막에 공백 추가
            }
            
            // 상단 세로
            else if (i > 0 && i < s + 1) {
                sb[i].append(numSegment.charAt(1) == '1' ? "|" : " ");
                // 왼쪽 상단 세그먼트가 켜져있는지 확인
                // 켜져 있으면 "|" 추가
                // 꺼져 있으면 " "(공백) 추가
                for (int j = 0; j < s; j++) sb[i].append(" ");
                // 세로 세그먼트 사이에 공백 추가
                sb[i].append(numSegment.charAt(2) == '1' ? "|" : " ");
                // 오른쪽 상단 세그먼트가 켜져있는지 확인
                // 켜져 있으면 "|" 추가
                // 꺼져 있으면 " "(공백) 추가
            }
            
            // 중단
            else if (i == s + 1) {
                sb[i].append(" "); // 줄의 처음에 공백 추가
                for (int j = 0; j < s; j++) sb[i].append(numSegment.charAt(3) == '1' ? "-" : " ");
                // 중단 세그먼트가 켜져있는지 확인
                // 켜져 있으면 "-" 추가
                // 꺼져 있으면 " "(공백) 추가
                sb[i].append(" "); // 줄의 마지막에 공백 추가
            }
            
            // 하단 세로
            else if (i > s + 1 && i < 2 * s + 2) {
                sb[i].append(numSegment.charAt(4) == '1' ? "|" : " ");
                // 왼쪽 하단 세그먼트가 켜져있는지 확인
                // 켜져 있으면 "|" 추가
                // 꺼져 있으면 " "(공백) 추가
                for (int j = 0; j < s; j++) sb[i].append(" "); // 세로 세그먼트 사이에 공백 추가
                sb[i].append(numSegment.charAt(5) == '1' ? "|" : " ");
                // 오른쪽 하단 세그먼트가 켜져있는지 확인
                // 켜져 있으면 "|" 추가
                // 꺼져 있으면 " "(공백) 추가
            }
            
            // 하단
            else if (i == 2 * s + 2) {
                sb[i].append(" "); // 줄 처음에 공백 추가
                for (int j = 0; j < s; j++) sb[i].append(numSegment.charAt(6) == '1' ? "-" : " ");
                // 하단 세그먼트가 켜져있는지 확인
                // 켜져 있으면 "-" 추가
                // 꺼져 있으면 " "(공백) 추가
                sb[i].append(" "); // 줄 마지막에 공백 추가
            }
        }
    }
}
