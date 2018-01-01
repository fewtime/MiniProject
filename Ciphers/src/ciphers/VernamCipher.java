package ciphers;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by cowlog on 18-1-1.
 * Implement Vernam cipher.
 */

public class VernamCipher implements Cipher {
    private final static String NAME = "Vernam Cipher";
    private final static char encryptionTable[] = {
            'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z'
    };
    private int plainTextLen = 0;

    VernamCipher(int plainTextLen) {
        this.plainTextLen = plainTextLen;
    }

    @Override
    public String generateKey() {
        if (plainTextLen <= 0) {
           return null;
        }

        StringBuilder key = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < plainTextLen; ++i) {
            int randomValue = secureRandom.nextInt(encryptionTable.length);
            key.append(encryptionTable[randomValue]);
        }

        return key.toString();
    }

    /*
     * Encrypt
     * Formula: key XOR with m
     * Return: cipher text or null if an error occurred.
     */
    @Override
    public String encrypt(String plainText, String key) {
        // Make sure the key and the plain text are the same length.
        if (plainText.length() != key.length()) {
            return null;
        }

        byte[] plainTextBytes = plainText.getBytes();
        byte[] keyBytes = key.getBytes();
        byte[] encryptedText = new byte[plainTextBytes.length];

        for (int i = 0; i < plainTextBytes.length; ++i) {
            encryptedText[i] = (byte)(keyBytes[i] ^ plainTextBytes[i]);
        }

        return new String(encryptedText);
    }

    /*
     * Decrypt
     * Formula: key XOR cipher text.
     * Return: plain text or null if an error occurred.
     */
    @Override
    public String decrypt(String cipherText, String key) {
        // Make sure the key and the cipher text are the same length.
        if (cipherText.length() != key.length()) {
            return null;
        }

        byte[] cipherTextBytes = cipherText.getBytes();
        byte[] keyBytes = key.getBytes();
        byte[] decryptedText = new byte[cipherTextBytes.length];

        for (int i = 0; i < cipherTextBytes.length; ++i) {
            decryptedText[i] = (byte)(keyBytes[i] ^ cipherTextBytes[i]);
            System.out.println(decryptedText[i]);
        }

        return new String(decryptedText).toUpperCase();
    }

    @Override
    public String getNAME() {
        return NAME;
    }
}
