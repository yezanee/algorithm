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
            String opcode = st.nextToken();
            int rD = Integer.parseInt(st.nextToken());
            int rA = Integer.parseInt(st.nextToken());
            int rB = Integer.parseInt(st.nextToken());
            if (opcode.charAt(opcode.length() - 1) == 'C') { // 마지막 문자 'C'인지 확인 (명령어가 상수 사용하는 지 확인)
                sb.append(hm.get(opcode.substring(0, opcode.length() - 1))).append("1");
                // C를 제외한 명령어 코드 1에 포함
            } else {
                sb.append(hm.get(opcode)).append("0"); // 명령어 코드에 '0'추가
            }
            sb.append("0"); // 사용하지 않는 bit 추가 (항상 0)

            String binary = Integer.toBinaryString(rD); // rD를 2진수 문자열로 변환
            String s = append(0, binary, 2); // rD를 2비트로 맞춰서 추가
            sb.append(append(0, binary, 2));
            
            // 특정 명령어는 rA를 사용하지 않음
            if (opcode == "NOT" || opcode == "MOV" || opcode == "MOVC") {
                sb.append("000"); // rA를 사용하지 않으므로 3비트 000 추가
            } else {
                String binary1 = Integer.toBinaryString(rA); // rA를 2진수 문자열로 변환
                sb.append(append(0, binary1, 2)); // rA를 2비트로 맞춰서 추가
            }
            String binary2 = Integer.toBinaryString(rB);
            if (opcode.charAt(opcode.length() - 1) == 'C') {
                sb.append(append(0, binary2, 3));
            } else {
                sb.append(append(0, binary2, 2)).append("0");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static String append(int depth, String str, int limit) {
        if (depth >= limit || limit < str.length()) {
            return str; // 현재 문자열 반환
        }
        return append(depth + 1, "0" + str, limit); // 왼쪽에 0을 추가한 문자열로 재귀 호출
    }
}