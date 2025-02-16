import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 1부터 N까지의 숫자를 담은 리스트 생성
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            numberList.add(i);
        }

        // 제거된 숫자들을 저장할 리스트
        List<Integer> resultList = new ArrayList<>();

        int index = 0; // 현재 인덱스
        while (!numberList.isEmpty()) {
            // K번째 사람의 인덱스는 현재 인덱스에서 K-1만큼 이동한 위치 (원형이므로 mod 사용)
            index = (index + K - 1) % numberList.size();
            // 해당 인덱스의 숫자를 결과 리스트에 추가하고 원래 리스트에서 제거
            resultList.add(numberList.remove(index));
        }

        // 결과 리스트를 문제에서 요구하는 형식 "<...>"로 출력
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < resultList.size(); i++) {
            sb.append(resultList.get(i));
            if (i != resultList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}