package encryptdecrypt;

public class UnicodeEncryptionMethod implements EncryptionMethod {

    @Override
    public String encrypt(String message, int key) {
        char[] encrypted = message.toCharArray();

        for (int i = 0; i < encrypted.length; i++) {
            encrypted[i] += key;
        }

        return String.valueOf(encrypted);
    }

    @Override
    public String decrypt(String message, int key) {
        return encrypt(message, -key);
    }
}
