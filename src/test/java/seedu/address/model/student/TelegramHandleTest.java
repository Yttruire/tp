package seedu.address.model.student;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TelegramHandleTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TelegramHandle(null));
    }

    @Test
    public void constructor_invalidTelegramHandle_throwsIllegalArgumentException() {
        String invalidTelegramHandle = "";
        assertThrows(IllegalArgumentException.class, () -> new TelegramHandle(invalidTelegramHandle));
    }

    @Test
    public void isValidTelegramHandle() {
        // null telegram handle number
        assertThrows(NullPointerException.class, () -> TelegramHandle.isValidTelegramHandle(null));

        // invalid telegram handle numbers
        assertFalse(TelegramHandle.isValidTelegramHandle("")); // empty string
        assertFalse(TelegramHandle.isValidTelegramHandle(" ")); // spaces only
        assertFalse(TelegramHandle.isValidTelegramHandle("pauline")); // missing @
        assertFalse(TelegramHandle.isValidTelegramHandle("@abcd")); // less than 5 characters
        assertFalse(TelegramHandle.isValidTelegramHandle("@Pauline")); // uppercase letters
        assertFalse(TelegramHandle.isValidTelegramHandle("@pauline chia")); // spaces within characters

        // valid telegram handle numbers
        assertTrue(TelegramHandle.isValidTelegramHandle("@abcde")); // exactly 5 characters
        assertTrue(TelegramHandle.isValidTelegramHandle("@pauline_chia"));
        assertTrue(TelegramHandle.isValidTelegramHandle("@abcdefg_1234567890_hijklmnop")); // long telegram handles
    }
}
