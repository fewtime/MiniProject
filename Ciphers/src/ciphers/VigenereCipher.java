package ciphers;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;

/**
 * Created by cowlog on 18-1-1.
 * Implement Vigenere Cipher.
 */

public class VigenereCipher implements Cipher {
    private final static String NAME = "Vigenere Cipher";
    private HashMap<Character, Integer> charMap;
    private final static char encryptionTable[] = {
            'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z'
    };
    private int plainTextLen = 0;

    VigenereCipher(int plainTextLen) {
        this.plainTextLen = plainTextLen;
        charMap = new HashMap<>();

        for (int i = 0; i < encryptionTable.length; ++i) {
            charMap.put(encryptionTable[i], i);
        }
    }

    @Override
    public String generateKey() {
        if (plainTextLen <= 0) {
            return null;
        }

        SecureRandom secureRandom = new SecureRandom();
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        int chosenLength = secureRandom.nextInt(plainTextLen);
        if (chosenLength == 0) {
            chosenLength = 1;
        }

        StringBuilder key = new StringBuilder();
        for (int i = 0; i < chosenLength; ++i) {
            int randomValue = secureRandom.nextInt(encryptionTable.length);
            key.append(encryptionTable[randomValue]);
        }

        return key.toString();
    }

    /*
     * Encrypt
     * Formula: m(i) + next character of the key (wrapping when necessary) mod (table size).
     * Return cipher text or null if an error occurred.
     */
    @Override
    public String encrypt(String plainText, String key) {
        StringBuilder encryptedText = new StringBuilder();

        // Make sure the key and plain text are valid.
        if (plainText.length() <= 0 || key.length() <= 0) {
            return null;
        }

        // Eliminates any whitespace and any alpha char's
        plainText = plainText.trim().replaceAll("\\W", "");
        if (plainText.contains(" ")) {
            plainText = plainText.replaceAll(" ", "");
        }
        key = key.trim();
        if (key.contains(" ")) {
            key = key.replaceAll(" ", "");
        }

        // Transform to upper case.
        plainText = plainText.toUpperCase();
        key = key.toUpperCase();

        // Encrypt
        for (int i = 0; i < plainText.length(); ++i) {
            char c = plainText.charAt(i);
            char kc = key.charAt(i % key.length());
            int encryptCharIndex = (charMap.get(c) + charMap.get(kc)) % encryptionTable.length;
            encryptedText.append(encryptionTable[encryptCharIndex]);
        }

        return encryptedText.toString();
    }

    /*
     * Decrypt
     * Formula: m(i) - next character of the key (wrapping when necessary) mod (table size).
     * Return: the plain text or null if an error occurred.
     */
    @Override
    public String decrypt(String cipherText, String key) {
        StringBuilder decryptedText = new StringBuilder();
        // Make sure the key and cipher text are valid.
        if (cipherText.length() <= 0 || key.length() <= 0) {
            return null;
        }

        // Eliminates any whitespace and any alpha char's
        cipherText = cipherText.trim().replaceAll("\\W", "");
        if (cipherText.contains(" ")) {
            cipherText= cipherText.replaceAll(" ", "");
        }
        key = key.trim();
        if (key.contains(" ")) {
            key = key.replaceAll(" ", "");
        }

        // Transform to upper case.
        cipherText = cipherText.toUpperCase();
        key = key.toUpperCase();

        // Decrypt
        for (int i = 0; i < cipherText.length(); ++i) {
            char c = cipherText.charAt(i);
            char kc = key.charAt(i % key.length());
            int decryptCharIndex = (charMap.get(c) - charMap.get(kc)) % encryptionTable.length;
            if (decryptCharIndex < 0) {
                decryptCharIndex += 26;
            }
            decryptedText.append(encryptionTable[decryptCharIndex]);
        }
        return decryptedText.toString();
    }

    @Override
    public String getNAME() {
        return NAME;
    }
}
