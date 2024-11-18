import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = N / 4;
        boolean isRemain = false;
        
        if (N % 4 != 0) isRemain = true;
        if (isRemain) cnt += 1;
        
        for(int i = 0; i < cnt; i++) {
            System.out.print("long ");
        }
        
        System.out.print("int");
    }
}