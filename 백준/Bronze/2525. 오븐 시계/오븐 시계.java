import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // 현재 시각의 시
        int B = sc.nextInt(); // 현재 시각의 분
        int C = sc.nextInt(); // 요리하는 데 필요한 시간 (분 단위)
        int hour = 0;

        B += C;

        while (B >= 60) {
            B -= 60;
            hour++;
        }

        A += hour;
        if(A >= 24) A -= 24;

        System.out.print(A + " " + B);
    }
}