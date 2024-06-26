import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 카드의 개수
        int[] L = new int[n]; // 카드 각각의 레벨 배열
        int gold = 0;
        
        for(int i = 0; i < n; i++) {
            L[i] = sc.nextInt(); // 카드 각각의 레벨 입력
        }
        
        if (n == 1) { // 카드 개수가 한장일 경우
            System.out.println(L[0]);
        }
        
        // 카드 개수가 2장 이상일 경우
        Arrays.sort(L); // 배열 오름차순 정렬
        for(int i = n-1; i > 0; i--) {
            gold += (L[i] + L[i-1]);
            L[i-1] = L[i];
        }
        
        System.out.println(gold);
    }
}