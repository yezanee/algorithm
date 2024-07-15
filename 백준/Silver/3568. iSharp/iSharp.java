import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        
        String init = "";
        List<String> v = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            // 공통된 변수형
            if (s.charAt(i) == ' ') {
                init = temp.toString();
                temp.setLength(0); // temp.clear() in Java
                continue;
            }
            // 하나의 추가적인 변수형 + 변수의 이름의 끝
            else if (s.charAt(i) == ',') {
                v.add(temp.toString());
                i++;
                temp.setLength(0);
            }
            // 끝
            else if (s.charAt(i) == ';') {
                v.add(temp.toString());
                temp.setLength(0);
            }
            else {
                temp.append(s.charAt(i));
            }
        }

        for (int i = 0; i < v.size(); i++) {
            String variable = v.get(i);
            int idx = -1;
            
            // 추가적인 변수형 유무 파악
            for (int j = 0; j < variable.length(); j++) {
                if (!Character.isLetter(variable.charAt(j))) {
                    idx = j;
                    break;
                }
            }

            System.out.print(init);
            // 추가적인 변수형이 없는 경우
            if (idx == -1) {
                System.out.println(" " + variable + ";");
            }
            // 추가적인 변수형이 있는 경우
            else {
                // 추가적인 변수형 역순으로 출력
                for (int j = variable.length() - 1; j >= idx; j--) {
                    // 역순으로 출력하지만 대괄호 순서는 맞아야 한다
                    if (variable.charAt(j) == ']') {
                        System.out.print("[]");
                        j--;
                        continue;
                    }
                    System.out.print(variable.charAt(j));
                }
                System.out.print(" ");
                for (int j = 0; j < idx; j++) {
                    System.out.print(variable.charAt(j));
                }
                System.out.println(";");
            }
        }
    }
}
