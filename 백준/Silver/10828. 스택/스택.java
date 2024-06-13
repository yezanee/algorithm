import java.util.Scanner;
public class Main {

	public static int[] stack;
	public static int size = 0;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = in.nextInt();
		stack = new int[N];
		
		for(int i = 0; i < N; i++) {
			String str = in.next();
			
			if (str.equals("push")) {
				push(in.nextInt());
			} else if (str.equals("pop")) {
				sb.append(pop()).append('\n');
			} else if (str.equals("size")) {
				sb.append(size()).append('\n');
			} else if (str.equals("empty")) {
				sb.append(empty()).append('\n');
			} else if (str.equals("top")) {
				sb.append(top()).append('\n');
			}
		}
		System.out.println(sb);
        in.close();
	}
	
	public static void push(int X) {
		stack[size] = X;
		size++;
	}
	
	public static int pop() {
		if (size == 0) {
			return -1;
		} else {
			int res = stack[size-1];
			stack[size-1] = 0;
			size--;
			return res;
		}
	}
	
	public static int size() {
		return size;
	}
	
	public static int empty() {
		if(size == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int top() {
		if (size == 0) {
			return -1;
		} else {
			return stack[size-1];
		}
	}
}
 