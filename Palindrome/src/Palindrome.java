import java.util.Scanner;

/**
 * Created by cowlog on 18-1-2.
 * Implement palindrome string.
 */

public class Palindrome {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a string: ");

        String s = sc.nextLine().toLowerCase();

        System.out.println(s + ": " + String.valueOf(Palindrome.isPalindrome(s)));
    }

    private static boolean isPalindrome(String s) {
        for (int left = 0, right = s.length() - 1; left <= right; ++left, --right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
