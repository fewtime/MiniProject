package ciphers;

/**
 * Created by cowlog on 18-1-1.
 * Cipher Interface
 */
public interface Cipher {
    int generateKey();
    String encrypt(String plainText, int key);
    String decrypt(String cipherText, int key);
    String getNAME();
}
