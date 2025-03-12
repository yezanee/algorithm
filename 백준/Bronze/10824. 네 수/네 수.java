import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Long.parseLong;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String AStr = st.nextToken();
    String BStr = st.nextToken();
    String CStr = st.nextToken();
    String DStr = st.nextToken();

    String ApulsB = AStr + BStr;
    String CpulsD = CStr + DStr;

    long num1 = parseLong(ApulsB);
    long num2 = parseLong(CpulsD);

    long sum = num1 + num2;

    System.out.println(sum);
  }
}
