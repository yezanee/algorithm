import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 여학생의 수
		int M = sc.nextInt(); // 남학생의 수
		int K = sc.nextInt(); // 인턴십에 참여해야하는 인원
		int maxTeam = 0; // 만들 수 있는 최대의 팀 수 (결과)
		
		/* 2명의 여학생과 1명의 남학생이 팀을 결성
		팀을 결성하면 총 인원에서 3명이 빠지고 또한 K명을 또 빼야한다.
		즉, 총 인원에서 K명을 인턴에 보내고 나머지 인원들 중
		3명으로 팀을 만들 수 있는 지 확인한다. */
		
		while (N >= 2 && M >= 1 && (N + M) - K >= 3) {
		    maxTeam++;
		    N -= 2;
		    M--;
		}
		
		System.out.println(maxTeam);
	}
}