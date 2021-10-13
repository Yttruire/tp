package seedu.address.model.group;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class GroupNameTest {
    @Test
    public void constructor_null_throwNullPointerException() {
        assertThrows(NullPointerException.class, () -> new GroupName(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidGroupName = "";
        assertThrows(IllegalArgumentException.class, () -> new GroupName(invalidGroupName));
    }

    @Test
    public void isValidGroupName() {
        // null group name
        assertThrows(NullPointerException.class, () -> GroupName.isValidName(null));

        // invalid name
        assertFalse(GroupName.isValidName("")); // empty string
        assertFalse(GroupName.isValidName(" ")); // spaces only
        assertFalse(GroupName.isValidName("^")); // only non-alphanumeric characters
        assertFalse(GroupName.isValidName("cs1231*")); // contains non-alphanumeric characters

        // valid name
        assertTrue(GroupName.isValidName("test mod")); // alphabets only
        assertTrue(GroupName.isValidName("12345")); // numbers only
        assertTrue(GroupName.isValidName("test mod the 2nd")); // alphanumeric characters
        assertTrue(GroupName.isValidName("Capital Mod")); // with capital letters
        assertTrue(GroupName.isValidName("David Roger Jackson Ray Jr 2nd Mod")); // long names
    }

}
