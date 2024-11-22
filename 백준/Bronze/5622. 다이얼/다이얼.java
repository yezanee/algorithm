import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> list = new HashMap<>();
        list.put(" ", 2);
        list.put("A", 3); list.put("B", 3); list.put("C", 3);
        list.put("D", 4); list.put("E", 4); list.put("F", 4);
        list.put("G", 5); list.put("H", 5); list.put("I", 5);
        list.put("J", 6); list.put("K", 6); list.put("L", 6);
        list.put("M", 7); list.put("N", 7); list.put("O", 7);
        list.put("P", 8); list.put("Q", 8); list.put("R", 8); list.put("S", 8);
        list.put("T", 9); list.put("U", 9); list.put("V", 9);
        list.put("W", 10); list.put("X", 10); list.put("Y", 10); list.put("Z", 10);
        list.put("+", 11); list.put("-", 11); list.put("*", 11); list.put("/", 11); list.put("%", 11);

        String str = sc.next();
        int time = 0;

        for(String s : str.split("")) {
            time += list.get(s);
        }

        System.out.println(time);

    }
}