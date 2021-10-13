package seedu.address.commons.util;

import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import seedu.address.commons.core.LogsCenter;

/**
 * Encrypts and decrypts files
 */
public class EncryptionUtil {

    private static final Logger logger = LogsCenter.getLogger(EncryptionUtil.class);

    /**
     * Returns a new Cipher instance backed by AES encryption.
     * @param opmode the operation mode of the cipher set to either
     */
    private static Cipher createCipherInstance(int opmode) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] keyBytes = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            String algorithm = "AES";
            SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);
            cipher.init(opmode, key, new IvParameterSpec(new byte[16]));
            return cipher;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | InvalidAlgorithmParameterException e) {
            logger.warning("Error create new Cipher instance with opmode" + opmode + ": " + e);
            throw new IllegalStateException(e);
        }
    }

    /**
     * Returns a new Cipher instance in Encrypt Mode
     */
    public static Cipher createEncryptCipherInstance() {
        return createCipherInstance(Cipher.ENCRYPT_MODE);
    }

    /**
     * Returns a new Cipher instance in Decrypt Mode
     */
    public static Cipher createDecryptCipherInstance() {
        return createCipherInstance(Cipher.DECRYPT_MODE);
    }

    /**
     * Encrypts the given Serializable object.
     * @param serializableObject the object to be encrypted
     * @return a Sealed Object instance containing the Serializable object
     * @throws IOException if there was an error during encryption
     */
    public static SealedObject encryptSerializableObject(Serializable serializableObject) throws IOException {
        try {
            return new SealedObject(serializableObject, createEncryptCipherInstance());
        } catch (IllegalBlockSizeException e) {
            logger.warning("Error encrypted serializable object " + serializableObject + ": " + e);
            throw new IOException(e);
        }
    }

    /**
     * Decrypts the given SealedObject object
     * @param sealedObject the object to be decrypted
     * @return a decrypted Serializable instance
     * @throws IOException if there was an error during decryption
     */
    public static Serializable decryptSealedObject(SealedObject sealedObject) throws IOException {
        try {
            return (Serializable) sealedObject.getObject(createDecryptCipherInstance());
        } catch (IOException | ClassNotFoundException | IllegalBlockSizeException
                | BadPaddingException e) {
            logger.warning("Error decrypting sealed object " + sealedObject + ": " + e);
            throw new IOException(e);
        }
    }
}
