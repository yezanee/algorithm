import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 시험 본 과목의 개수
        double[] score = new double[N]; // 세준이의 현재 성적
        int index = 0;
        for(; index < N; index++) {
            score[index] = sc.nextDouble();
        }

        Arrays.sort(score);
        double max = score[index-1];
        double avg = 0;

        for(double i : score) { avg += (i / max) * 100; }

        avg = avg / N;

        System.out.println(avg);

    }
}