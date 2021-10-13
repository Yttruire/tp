package seedu.address.model.group;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GROUP_DESCRIPTION_CS1101S;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GROUP_NAME;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GROUP_NAME_CS1101S;
import static seedu.address.testutil.TypicalGroup.CS1231S;
import static seedu.address.testutil.TypicalGroup.DEFAULT_GROUP;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.GroupBuilder;


public class GroupTest {

    @Test
    public void isSameGroup() {
        // same object -> returns true
        assertTrue(DEFAULT_GROUP.isSameGroup(DEFAULT_GROUP));

        // null -> returns false
        assertFalse(DEFAULT_GROUP.isSameGroup(null));

        // same name, all other attributes different -> returns true
        Group editedDefaultGroup = new GroupBuilder(DEFAULT_GROUP).withDescription(VALID_DESC_BOB).build();
        assertTrue(DEFAULT_GROUP.isSameGroup(editedDefaultGroup));

        // name differs in case, all other attributes same -> returns false
        editedDefaultGroup = new GroupBuilder(DEFAULT_GROUP)
                .withGroupName(VALID_GROUP_NAME.toLowerCase()).build();
        assertFalse(DEFAULT_GROUP.isSameGroup(editedDefaultGroup));

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_GROUP_NAME + " ";
        editedDefaultGroup = new GroupBuilder(DEFAULT_GROUP).withGroupName(nameWithTrailingSpaces).build();
        assertFalse(DEFAULT_GROUP.isSameGroup(editedDefaultGroup));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Group defaultCopy = new GroupBuilder(DEFAULT_GROUP).build();
        assertTrue(DEFAULT_GROUP.equals(defaultCopy));

        // same object -> returns true
        assertTrue(DEFAULT_GROUP.equals(DEFAULT_GROUP));

        // null -> returns false
        assertFalse(DEFAULT_GROUP.equals(null));

        // different group -> returns false
        assertFalse(DEFAULT_GROUP.equals(CS1231S));

        // different name -> returns false
        Group editedDefaultGroup = new GroupBuilder(DEFAULT_GROUP).withGroupName(VALID_GROUP_NAME_CS1101S).build();
        assertFalse(DEFAULT_GROUP.equals(editedDefaultGroup));

        // different description -> returns false
        editedDefaultGroup = new GroupBuilder(DEFAULT_GROUP).withDescription(VALID_GROUP_DESCRIPTION_CS1101S).build();
        assertFalse(DEFAULT_GROUP.equals(editedDefaultGroup));
    }
}
