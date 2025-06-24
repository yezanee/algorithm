import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(sc.next()); // 큰 수 입력
        BigInteger m = new BigInteger(sc.next()); // 나눌 사람 수

        System.out.println(n.divide(m)); // 몫
        System.out.println(n.remainder(m)); // 나머지
    }
}
