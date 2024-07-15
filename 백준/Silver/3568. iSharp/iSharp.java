import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim(); // 입력된 문자열을 읽고, 앞뒤 공백 제거
        
        String init = ""; // 공통 데이터 타입을 저장할 변수
        List<String> v = new ArrayList<>(); // 변수 선언들을 저장할 리스트
        StringBuilder temp = new StringBuilder(); // 임시로 문자열을 저장
        
        // 입력된 문자열을 한 글자씩 순회
        for (int i = 0; i < s.length(); i++) {
            // 공백을 만나면 공통 데이터 타입을 저장
            if (s.charAt(i) == ' ') {
                init = temp.toString();
                temp.setLength(0); // temp를 초기화
                continue; // 다음 문자로 이동
            }
            // 쉼표를 만나면 하나의 변수 선언을 리스트에 추가
            else if (s.charAt(i) == ',') {
                v.add(temp.toString()); // temp에 저장된 변수를 리스트에 추가
                i++; // 쉼표 다음 글자로 이동
                temp.setLength(0); // temp를 초기화
            }
            // 세미콜론을 만나면 하나의 변수 선언을 리스트에 추가
            else if (s.charAt(i) == ';') {
                v.add(temp.toString()); // temp에 저장된 변수를 리스트에 추가
                temp.setLength(0); // temp를 초기화
            }
            // 그 외의 문자들은 temp에 추가
            else {
                temp.append(s.charAt(i));
            }
        }

        // 리스트에 저장된 각 변수를 처리
        for (int i = 0; i < v.size(); i++) {
            String variable = v.get(i); // 리스트에서 변수 선언을 가져옴
            int idx = -1; // 변수명과 추가적인 변수형을 구분할 인덱스
            
            // 변수 선언에서 문자와 기호를 구분
            for (int j = 0; j < variable.length(); j++) {
                if (!Character.isLetter(variable.charAt(j))) {
                    idx = j; // 문자 외의 기호가 나오는 첫 번째 인덱스를 저장
                    break; // 루프 종료
                }
            }

            System.out.print(init); // 공통 데이터 타입을 출력
            // 추가적인 변수형이 없는 경우
            if (idx == -1) {
                System.out.println(" " + variable + ";"); // 변수명만 출력
            }
            // 추가적인 변수형이 있는 경우
            else {
                // 추가적인 변수형을 역순으로 출력
                for (int j = variable.length() - 1; j >= idx; j--) {
                    // 대괄호 순서는 맞추기 위해 특별히 처리
                    if (variable.charAt(j) == ']') {
                        System.out.print("[]");
                        j--; // '[' 문자를 건너뜀
                        continue;
                    }
                    System.out.print(variable.charAt(j)); // 역순으로 출력
                }
                System.out.print(" ");
                // 변수명을 출력합니다.
                for (int j = 0; j < idx; j++) {
                    System.out.print(variable.charAt(j));
                }
                System.out.println(";"); // 세미콜론으로 끝맺음
            }
        }
    }
}
