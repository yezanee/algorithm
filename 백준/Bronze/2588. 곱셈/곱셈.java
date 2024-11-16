import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        int input2 = sc.nextInt();
        
        int a = input2 % 10;
        input2 = input2 / 10;
        int b = input2 % 10;
        input2 = input2 / 10;
        int c = input2 % 10;

        int result1 = input1 * a;
        int result2 = input1 * b * 10;
        int result3 = input1 * c * 100;
        int result_end = result1 + result2 + result3;

        System.out.println(result1);
        System.out.println(result2 / 10);
        System.out.println(result3 / 100);
        System.out.println(result_end);
        
    }
}