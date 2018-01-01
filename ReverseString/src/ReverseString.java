import java.util.Scanner;

/**
 * Created by cowlog on 18-1-1.
 * Implement Reverse string.
 */
public class ReverseString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input a string: ");

        String s = in.nextLine();
        String reverseS = new StringBuilder(s).reverse().toString();

        System.out.println("Reverse: " + reverseS);
    }
}
