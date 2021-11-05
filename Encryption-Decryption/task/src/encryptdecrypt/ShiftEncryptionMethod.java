package encryptdecrypt;

public class ShiftEncryptionMethod implements EncryptionMethod {

    @Override
    public String encrypt(String message, int key) {
        char[] encrypted = message.toCharArray();

        for (int i = 0; i < encrypted.length; i++) {
            char c = encrypted[i];
            if (c >= 'a' && c <= 'z') {
                encrypted[i] = shift(c, 'a', key);
            } else if (c >= 'A' && c <= 'Z') {
                encrypted[i] = shift(c, 'A', key);
            }
        }

        return String.valueOf(encrypted);
    }

    @Override
    public String decrypt(String message, int key) {
        return encrypt(message, -key);
    }

    private char shift(char c, char offset, int key) {
        int result =  (c - offset + key) % 26;
        return (char) ((result < 0 ? result + 26 : result) + offset);
    }
}