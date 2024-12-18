import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] subject = new String[20];
        double[] credit = new double[20];
        String[] grade = new String[20];
        double[] gradeParseNumber = new double[20];
        double exception = 0;
        double result = 0;
        double result2 = 0;

        for(int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            subject[i] = st.nextToken();
            credit[i] = Double.parseDouble(st.nextToken());
            grade[i] = st.nextToken();

            if(grade[i].equals("A+")) {
                gradeParseNumber[i] = 4.5;
            } else if (grade[i].equals("A0")) {
                gradeParseNumber[i] = 4.0;
            } else if (grade[i].equals("B+")) {
                gradeParseNumber[i] = 3.5;
            } else if (grade[i].equals("B0")) {
                gradeParseNumber[i] = 3.0;
            } else if (grade[i].equals("C+")) {
                gradeParseNumber[i] = 2.5;
            } else if (grade[i].equals("C0")) {
                gradeParseNumber[i] = 2.0;
            } else if (grade[i].equals("D+")) {
                gradeParseNumber[i] = 1.5;
            } else if (grade[i].equals("D0")) {
                gradeParseNumber[i] = 1.0;
            } else if (grade[i].equals("P")) {
                exception += credit[i];
                gradeParseNumber[i] = 0.0;
            } else if (grade[i].equals("F")) {
                gradeParseNumber[i] = 0.0;
            }
        }

        for(int i = 0; i < 20; i++) {
            result += gradeParseNumber[i] * credit[i];
            result2 += credit[i];
        }

        result2 -= exception;

        result = result / result2;

        System.out.println(result);
    }

}