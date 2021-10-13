package seedu.address.commons.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SealedObject;

/**
 * Writes and reads files
 */
public class FileUtil {

    private static final String CHARSET = "UTF-8";

    public static boolean isFileExists(Path file) {
        return Files.exists(file) && Files.isRegularFile(file);
    }

    /**
     * Returns true if {@code path} can be converted into a {@code Path} via {@link Paths#get(String)},
     * otherwise returns false.
     * @param path A string representing the file path. Cannot be null.
     */
    public static boolean isValidPath(String path) {
        try {
            Paths.get(path);
        } catch (InvalidPathException ipe) {
            return false;
        }
        return true;
    }

    /**
     * Creates a file if it does not exist along with its missing parent directories.
     * @throws IOException if the file or directory cannot be created.
     */
    public static void createIfMissing(Path file) throws IOException {
        if (!isFileExists(file)) {
            createFile(file);
        }
    }

    /**
     * Creates a file if it does not exist along with its missing parent directories.
     */
    public static void createFile(Path file) throws IOException {
        if (Files.exists(file)) {
            return;
        }

        createParentDirsOfFile(file);

        Files.createFile(file);
    }

    /**
     * Creates parent directories of file if it has a parent directory
     */
    public static void createParentDirsOfFile(Path file) throws IOException {
        Path parentDir = file.getParent();

        if (parentDir != null) {
            Files.createDirectories(parentDir);
        }
    }

    /**
     * Assumes file exists
     */
    public static String readFromFile(Path file) throws IOException {
        return new String(Files.readAllBytes(file), CHARSET);
    }

    /**
     * Reads from the encrypted file.
     * Assumes encrypted file exists.
     * @param encryptedFile cannot be null
     * @return An instance of Sealed Object containing the encrypted data
     * @throws IOException if there was an error during reading from the file
     */
    public static SealedObject readFromEncryptedFile(Path encryptedFile) throws IOException {
        try {
            CipherInputStream cipherInputStream = new CipherInputStream(new BufferedInputStream(
                    new FileInputStream(encryptedFile.toFile())),
                    EncryptionUtil.createDecryptCipherInstance());
            ObjectInputStream inputStream = new ObjectInputStream(cipherInputStream);
            return (SealedObject) inputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }

    /**
     * Writes given string to a file.
     * Will create the file if it does not exist yet.
     */
    public static void writeToFile(Path file, String content) throws IOException {
        Files.write(file, content.getBytes(CHARSET));
    }

    /**
     * Writes given Sealed Object to encrypted file.
     * @param encryptedFile cannot be null
     * @param content cannot be null
     * @throws IOException if there was an error during writing to the file
     */
    public static void writeToEncryptedFile(Path encryptedFile, SealedObject content) throws IOException {
        CipherOutputStream cipherOutputStream = new CipherOutputStream(new BufferedOutputStream(
                new FileOutputStream(encryptedFile.toFile())),
                EncryptionUtil.createEncryptCipherInstance());
        ObjectOutputStream outputStream = new ObjectOutputStream(cipherOutputStream);
        outputStream.writeObject(content);
        outputStream.close();
    }
}
