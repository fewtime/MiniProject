package generator;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by cowlog on 18-1-4.
 * Implement Generator
 */
public class Generator {
    private int splitTime = 0;
    private int pre = 0;
    private final static char encryptionTable[] = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9'
    };

    public Generator() {
        this.splitTime = 0;
        this.pre = 0;
    }

    public Generator(int splitTime, int pre) {
        this.splitTime = splitTime;
        this.pre = pre;
    }

    public String get() {
        SecureRandom secureRandom = new SecureRandom();
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        StringBuilder key = new StringBuilder();

        for (int turn = 1; turn <= splitTime; ++turn) {
            for (int i = 0; i < pre; ++i) {
                int randomValue = secureRandom.nextInt(encryptionTable.length);
                key.append(encryptionTable[randomValue]);
            }

            if (turn != splitTime) {
                key.append('-');
            }

        }

        return key.toString();
    }
}
