package encryptdecrypt;

public class EncryptionMethodFactory {

    public static EncryptionMethod newInstance(String method) {

        if ("shift".equals(method)) {
            return new ShiftEncryptionMethod();
        } else if ("unicode".equals(method)) {
            return new UnicodeEncryptionMethod();
        }

        return null;
    }

}
