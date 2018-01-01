import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by cowlog on 18-1-2.
 * Implement Count vowel.
 */
public class CountVowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> cntMap = new HashMap<>();
        final String vowel = "aeiou";
        for (int i = 0; i < vowel.length(); ++i) {
            cntMap.put(vowel.charAt(i), 0);
        }
        System.out.println("Input a string: ");
        String s = sc.nextLine().toLowerCase();

        for (int i = 0; i < s.length(); ++i) {
            if (vowel.contains(s.charAt(i) + "")) {
                cntMap.put(s.charAt(i), cntMap.get(s.charAt(i)) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            String key = entry.getKey().toString();
            String value = Integer.toString(entry.getValue());
            System.out.println(key + " -- " + value);
        }

    }
}
