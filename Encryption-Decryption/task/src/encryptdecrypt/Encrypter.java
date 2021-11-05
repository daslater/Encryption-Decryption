package encryptdecrypt;

/**
 * Encrypter class is used as a context object for strategy pattern. It takes in
 * an encryption method object and calls that object's encrypt and decrypt methods
 */
class Encrypter {

    private EncryptionMethod method;

    /**
     * Sets encryption/decryption algorithm that will be used
     * @param method Encryption method to be used
     */
    public void setMethod(EncryptionMethod method) {
        this.method = method;
    }

    /**
     * Encrypts message using selected encryption method
     * @param message Plaintext to be encrypted
     * @param key Encryption key
     * @return Encrypted message
     */
    public String encrypt(String message, int key) {
        return this.method.encrypt(message, key);
    }

    /**
     * Decrypts message using selected decryption method
     * @param message Cyphertext to be decrypted
     * @param key Decryption key
     * @return Decrypted message
     */
    public String decrypt(String message, int key) {
        return this.method.decrypt(message, key);
    }

}