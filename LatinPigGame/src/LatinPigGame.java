import java.util.Scanner;

/**
 * Created by cowlog on 18-1-1.
 * Implement Latin pig game.
 */
public class LatinPigGame {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a string: ");

        String word = sc.nextLine().toLowerCase();
        final String vowel = "aeiou";

        int flag;
        String temp = ""; // non-vowel char
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < word.length(); ++i) {
           flag = vowel.indexOf(String.valueOf(word.charAt(i)));

           if (flag == -1) {
               temp = String.valueOf(word.charAt(i));
               sb.deleteCharAt(i);
               break;
           }
        }

        word = sb.toString() + "-" + temp + "ay";

        System.out.println("Latin pig: " + word);
    }

}
