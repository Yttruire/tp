package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalStudents.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.group.Group;
import seedu.address.model.group.GroupName;

/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code DeleteCommand}.
 */
public class DeleteGroupCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_validGroup_success() {
        Group groupToDelete = model.getFilteredGroupList().get(0);
        DeleteGroupCommand deleteGroupCommand = new DeleteGroupCommand(groupToDelete.getGroupName());

        String expectedMessage = String.format(DeleteGroupCommand.MESSAGE_DELETE_GROUP_SUCCESS, groupToDelete);

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.deleteGroup(groupToDelete);

        assertCommandSuccess(deleteGroupCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidGroup_throwsCommandException() {
        String nonExistentGroupName = "qwertyuiopasdfghjklzxcvbnm";

        assertTrue(GroupName.isValidName(nonExistentGroupName));

        DeleteGroupCommand deleteGroupCommand = new DeleteGroupCommand(new GroupName(nonExistentGroupName));

        assertCommandFailure(deleteGroupCommand, model, Messages.MESSAGE_GROUP_NOT_FOUND);
    }


    @Test
    public void equals() {
        final GroupName firstGroupName = model.getFilteredGroupList().get(0).getGroupName();
        final GroupName secondGroupName = model.getFilteredGroupList().get(1).getGroupName();

        DeleteGroupCommand deleteFirstCommand = new DeleteGroupCommand(firstGroupName);
        DeleteGroupCommand deleteSecondCommand = new DeleteGroupCommand(secondGroupName);

        // same object -> returns true
        assertTrue(deleteFirstCommand.equals(deleteFirstCommand));

        // same values -> returns true
        DeleteGroupCommand deleteFirstCommandCopy = new DeleteGroupCommand(firstGroupName);
        assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));

        // different types -> returns false
        assertFalse(deleteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteFirstCommand.equals(null));

        // different group -> returns false
        assertFalse(deleteFirstCommand.equals(deleteSecondCommand));
    }
}
