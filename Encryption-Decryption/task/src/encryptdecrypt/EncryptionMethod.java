package encryptdecrypt;

public interface EncryptionMethod {

    public String encrypt(String message, int key);

    public String decrypt(String message, int key);
}
