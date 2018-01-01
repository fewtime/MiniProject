package ciphers;

/**
 * Created by cowlog on 18-1-1.
 * Cipher Interface
 */
public interface Cipher {
    String generateKey();
    String encrypt(String plainText, String key);
    String decrypt(String cipherText, String key);
    String getNAME();

    static Object factory(int k, int plainTextLen) {
        Cipher cipher = null;
        switch (k) {
            case 0: cipher = new CaesarCipher(); break;
            case 1: cipher = new VernamCipher(plainTextLen); break;
//            case 2: cipher = new VigenereCipher(plainTextLen); break;
            default: break;
        }
        return cipher;
    }
}
