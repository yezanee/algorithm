import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		int[] num = new int[len];
		
		for(int i=0; i<len; i++) {
			num[i] = Integer.parseInt(str.substring(i, i+1));
		}
		
		for(int i=0; i<len; i++) {
			int max = i;
			for (int j=i+1; j<len; j++) { // 최댓값 위치 찾기
				if(num[max] < num[j]) max = j; 
			}
			if (num[i] < num[max]) { // 찾은 최댓값을 현재 자리로 교환
				int temp = num[i];
				num[i] = num[max];
				num[max] = temp;
			}
		}
		
		for(int i=0; i<len; i++) System.out.print(num[i]);
	}
}