import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       ArrayList<Integer> list = new ArrayList<>();
       StringBuilder sb = new StringBuilder();
       
       int current = 1;  // 다음에 push할 숫자
       for (int i = 0; i < N; i++) {
           int num = Integer.parseInt(br.readLine());
           
           // 현재까지 숫자(current)부터 목표 숫자(num)까지 push
           while (current <= num) {
               list.add(current++);
               sb.append("+\n");
           }
           
           // 마지막에 들어간 숫자가 num과 같다면 pop
           if (!list.isEmpty() && list.get(list.size() - 1) == num) {
               list.remove(list.size() - 1);
               sb.append("-\n");
           } else {
               // 원하는 수열을 만들 수 없는 경우
               System.out.println("NO");
               return;
           }
       }
       System.out.print(sb);
    }
}
