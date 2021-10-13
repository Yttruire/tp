package seedu.address.commons.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.Serializable;
import javax.crypto.Cipher;
import javax.crypto.SealedObject;

import org.junit.jupiter.api.Test;

/**
 * Tests encryption and decryption
 */
public class EncryptionUtilTest {

    @Test
    public void createCipherInstanceWithEncryptMode_noExceptionThrown() {
        assertTrue(EncryptionUtil.createEncryptCipherInstance() instanceof Cipher);
    }

    @Test
    public void createCipherInstanceWithDecryptMode_noExceptionThrown() {
        assertTrue(EncryptionUtil.createDecryptCipherInstance() instanceof Cipher);
    }

    @Test
    public void encryptSerializableObjectWithSerializableObject_noExceptionThrown() throws IOException {
        assertTrue(EncryptionUtil.encryptSerializableObject("") instanceof SealedObject);
    }

    @Test
    public void decryptSealedObjectWithSealedObject_noExceptionThrown() throws IOException {
        SealedObject sealedObject = EncryptionUtil.encryptSerializableObject("");
        assertTrue(EncryptionUtil.decryptSealedObject(sealedObject) instanceof Serializable);
    }
}
