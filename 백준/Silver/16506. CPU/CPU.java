import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.HashMap; 
import java.util.StringTokenizer; 

public class Main {
    static HashMap<String, String> hm = new HashMap<>(); // 명령어(opcode)와 해당 4비트 2진수를 매핑하는 해시맵

    public static void main(String[] args) throws IOException {
        // 해시맵 hm에 명령어와 해당하는 4비트 2진수를 저장
        hm.put("ADD", "0000");
        hm.put("SUB", "0001");
        hm.put("MOV", "0010");
        hm.put("AND", "0011");
        hm.put("OR", "0100");
        hm.put("NOT", "0101");
        hm.put("MULT", "0110");
        hm.put("LSFTL", "0111");
        hm.put("LSFTR", "1000");
        hm.put("ASFTR", "1001");
        hm.put("RL", "1010");
        hm.put("RR", "1011");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine()); // 명령어의 개수
        StringBuilder sb = new StringBuilder(); 
        while (n-- > 0) { 
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            String opcode = st.nextToken(); // 첫 번째 토큰은 명령어 (opcode)
            int rD = Integer.parseInt(st.nextToken()); // 두 번째 토큰은 목적지 레지스터 (rD)
            int rA = Integer.parseInt(st.nextToken()); // 세 번째 토큰은 소스 레지스터 1 (rA)
            int rB = Integer.parseInt(st.nextToken()); // 네 번째 토큰은 소스 레지스터 2 또는 상수 (rB 또는 #C)
            if (opcode.charAt(opcode.length() - 1) == 'C') { // 명령어가 상수를 사용하는지 확인 (마지막 문자가 'C'인지 확인)
                sb.append(hm.get(opcode.substring(0, opcode.length() - 1))).append("1"); // 'C'를 제외한 명령어 코드에 '1' 추가
            } else {
                sb.append(hm.get(opcode)).append("0"); // 명령어 코드에 '0' 추가
            }
            sb.append("0"); // 사용하지 않는 비트 추가 (항상 0)

            String binary = Integer.toBinaryString(rD); // rD를 2진수 문자열로 변환
            String s = append(0, binary, 2); // rD를 3비트로 맞춰서 추가 (사용할 변수를 s로 저장)
            sb.append(append(0, binary, 2)); // rD를 3비트로 맞춰서 sb에 추가
            
            // 특정 명령어는 rA를 사용하지 않음
            if (opcode.equals("NOT") || opcode.equals("MOV") || opcode.equals("MOVC")) {
                sb.append("000"); // rA를 사용하지 않으므로 3비트 000 추가
            } else {
                String binary1 = Integer.toBinaryString(rA); // rA를 2진수 문자열로 변환
                sb.append(append(0, binary1, 2)); // rA를 3비트로 맞춰서 sb에 추가
            }
            String binary2 = Integer.toBinaryString(rB); // rB를 2진수 문자열로 변환
            if (opcode.charAt(opcode.length() - 1) == 'C') { // 명령어가 상수를 사용하는지 확인
                sb.append(append(0, binary2, 3)); // 상수는 4비트로 맞춰서 추가
            } else {
                sb.append(append(0, binary2, 2)).append("0"); // rB는 3비트로 맞추고 마지막 비트는 0 추가
            }
            sb.append("\n"); // 명령어의 끝에 개행 문자 추가
        }
        System.out.println(sb); // 최종 결과 출력
    }

    // 주어진 문자열을 지정된 길이로 맞추기 위해 왼쪽에 0을 추가하는 재귀 함수
    private static String append(int depth, String str, int limit) {
        if (depth >= limit || limit < str.length()) { // 재귀 종료 조건: depth가 limit 이상이거나, str의 길이가 limit 이상인 경우
            return str; // 현재 문자열 반환
        }
        return append(depth + 1, "0" + str, limit); // 왼쪽에 0을 추가한 문자열로 재귀 호출
    }
}