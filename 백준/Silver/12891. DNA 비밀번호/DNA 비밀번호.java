import java.util.*;
import java.io.*;

public class Main {
	static char[] dnaStrToArr;
	static int[] cntArr = new int[4];
	
	public static void check(int idx, int sign) {
			if(dnaStrToArr[idx] == 'A') cntArr[0] += sign;
			else if (dnaStrToArr[idx] == 'C') cntArr[1] += sign;
			else if (dnaStrToArr[idx] == 'G') cntArr[2] += sign;
			else if (dnaStrToArr[idx] == 'T') cntArr[3] += sign;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken()); // 문자열 길이
 		int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
 		
 		String dnaStr = br.readLine();
 		dnaStrToArr = dnaStr.toCharArray();
 		
	 	int[] minCnt = new int[4]; // 부분문자열에 포함되어야 할 최소값
 		st = new StringTokenizer(br.readLine());
 		for(int i=0; i<4; i++) {
	 		minCnt[i] = Integer.parseInt(st.nextToken());
	 	}
	 	
	 	int startIdx = 0;
	 	int endIdx = P-1;
	 	int cnt = 0;
	 	
		for(int i = startIdx; i<=endIdx; i++) {
			check(i, 1);
		}
		
		if (cntArr[0] >= minCnt[0] && cntArr[1] >= minCnt[1]
			&& cntArr[2] >= minCnt[2] && cntArr[3] >= minCnt[3]) cnt++;
			
	 	while(endIdx < S-1) {	
	 	
		 	check(startIdx, -1);
		 	startIdx++;
		 	endIdx++;
		 	check(endIdx, 1);
			
			if (cntArr[0] >= minCnt[0] && cntArr[1] >= minCnt[1]
				&& cntArr[2] >= minCnt[2] && cntArr[3] >= minCnt[3]) cnt++;
		}
		
		System.out.println(cnt);
	}
}