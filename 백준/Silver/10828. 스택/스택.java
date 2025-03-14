import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(st2.nextToken());

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      if (command.startsWith("push")) {
          int X = Integer.parseInt(st.nextToken());
          stack.push(X);
      } else if (command.equals("pop")) {
        sb.append(popStack(stack) + "\n");

      } else if (command.equals("size")) {
        sb.append(stack.size() + "\n");

      } else if (command.equals("empty")) {
        sb.append(stackIsEmpty(stack) + "\n");

      } else if (command.equals("top")) {
        sb.append(stackTop(stack) + "\n");
      }
    }

    System.out.println(sb.toString());

  }

  public static int popStack(Stack<Integer> stack) {
    if (stack.isEmpty()) {
      return -1;
    } else {
      return stack.pop();
    }
  }

  public static int stackIsEmpty(Stack<Integer> stack) {
    boolean isEmpty = stack.empty();
    if (isEmpty) {
      return 1;
    } else {
      return 0;
    }
  }

  public static int stackTop(Stack<Integer> stack) {
    if (stack.isEmpty()) {
      return -1;
    } else {
      return stack.peek();
    }
  }

}
