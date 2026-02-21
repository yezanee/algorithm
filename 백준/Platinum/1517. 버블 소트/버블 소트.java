import java.util.*;
import java.io.*;

public class Main{
	public static int[] A, tmp;
	public static long result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		A = new int[N+1]; // 1-based
		tmp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		result = 0;
		merge_sort(1, N);
		System.out.println(result);
	}
	
	private static void merge_sort(int s, int e) {
		if (e-s < 1) return; // 구간 길이가 1 이하 = 이미 정렬된 상태 (s >= e)
		int m = s + (e-s) / 2; // 정수 오버플로우 방지
		
		merge_sort(s, m);
		merge_sort(m+1, e);
		
		for(int i=s; i<=e; i++) {
			tmp[i] = A[i];
		}
		
		int k = s;
		int index1 = s;
		int index2 = m + 1;
		while (index1 <= m && index2 <= e) {
			// 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고,
      // 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동하기
			if (tmp[index1] > tmp[index2]) {
			  A[k] = tmp[index2];
			  result = result + index2 - k;
	      k++;
        index2++;
      } else {
        A[k] = tmp[index1];
        k++;
	      index1++;
      }
		}
		
		while (index1 <= m) { // 한쪽 그룹이 모두 선택된 후 남아있는 값 제거하기
			A[k] = tmp[index1];
			k++;
			index1++;
		}
		
		while(index2 < e) {
			A[k] = tmp[index2];
			k++;
			index2++;
		}
	}
}