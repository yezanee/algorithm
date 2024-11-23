import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        char[] wordOppositeArr = new char[word.length()];
        int index = word.length() - 1;

        for(int i = 0; i < wordOppositeArr.length; i++)  {
            wordOppositeArr[i] = word.charAt(index--);
        }

        String wordOpposite = String.valueOf(wordOppositeArr);

        if (word.equals(wordOpposite)) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
    }
}