package ciphers;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;

/**
 * Created by cowlog on 18-1-1.
 * Implement CaesarCipher
 */

public class CaesarCipher implements Cipher {
    private final static String NAME = "Caesar Cipher";
    private HashMap<Character, Integer> charMap;
    private final static char encryptionTable[] = {
            'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z'
    };

    CaesarCipher() {
        charMap = new HashMap<>();
        for (int i = 0; i < encryptionTable.length; ++i) {
            charMap.put(encryptionTable[i], i);
        }
    }

    // Return an integer between 0 - 25.
    public String generateKey() {
        SecureRandom secureRandom = new SecureRandom();
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return Integer.toString(secureRandom.nextInt(26));
    }

    /*
     * Encrypt
     * Formula: (m(i) + key) mod 26.
     * Return: cipher text or null if an error occurred.
     */
    public String encrypt(String plainText, String key) {
        int ikey = Integer.parseInt(key);
        StringBuilder encryptedText = new StringBuilder();

        // Check the key's and plainText's validation.
        if (ikey < 0 || ikey > 25 || plainText.length() <= 0) {
            return null;
        }

        // Eliminate any whitespace and non alpha char's.
        plainText = plainText.trim().replaceAll("\\W", "");
        if (plainText.contains(" ")) {
            plainText = plainText.replaceAll(" ", "");
        }

        // Transform to upper case.
        plainText = plainText.toUpperCase();

        // Encrypt
        for (int i = 0; i < plainText.length(); ++i) {
            int encryptedCharIndex = (charMap.get(plainText.charAt(i)) + ikey) % 26;
            encryptedText.append(encryptionTable[encryptedCharIndex]);
        }

        return encryptedText.toString();
    }

    /*
     * Decrypt
     * Formula: (c(i) - key) mod 26.
     * Return: plain text or null if an error occurred.
     */
    public String decrypt(String cipherText, String key) {
        int ikey = Integer.parseInt(key);
        StringBuilder decryptedText = new StringBuilder();

        // Check the key's and cipher text's validation.
        if (ikey < 0 || ikey > 26 || cipherText.length() <= 0) {
            return null;
        }

        // Eliminate any whitespace and non alpha char's.
        cipherText = cipherText.trim().replaceAll("\\W", "");
        if (cipherText.contains(" ")) {
            cipherText = cipherText.replaceAll(" ", "");
        }

        // Transform to upper case.
        cipherText = cipherText.toUpperCase();

        // Decrypt
        for (int i = 0; i < cipherText.length(); ++i) {
            int decryptedCharIndex = (charMap.get(cipherText.charAt(i)) - ikey) % 26;
            if (decryptedCharIndex < 0) {
                decryptedCharIndex += 26;
            }
            decryptedText.append(encryptionTable[decryptedCharIndex]);
        }

        return decryptedText.toString();
    }

    public String getNAME() {
        return NAME;
    }
}
