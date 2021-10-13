package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import javafx.collections.ObservableList;
import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.group.Description;
import seedu.address.model.group.Group;
import seedu.address.model.group.GroupName;
import seedu.address.model.student.ContainsGroupNamePredicate;

/**
 * Displays all students in a group that has the given group name.
 */
public class ViewGroupCommand extends Command {

    public static final String COMMAND_WORD = "viewgroup";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Find and displays details about a group that matches "
            + "the specified group name (case-sensitive).\n"
            + "Parameters: GROUPNAME \n"
            + "Example: " + COMMAND_WORD + " CS2103T";

    private final ContainsGroupNamePredicate predicate;

    private final GroupName groupName;

    /**
     * Creates a ViewGroupCommand to find a {@code Group} with the specified {@code GroupName}
     */
    public ViewGroupCommand(ContainsGroupNamePredicate predicate, GroupName groupName) {
        this.predicate = predicate;
        this.groupName = groupName;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredStudentList(predicate);
        String displayedText = getGroupInformation(model) + "\n" + Messages.MESSAGE_STUDENTS_LISTED_OVERVIEW;
        return new CommandResult(
                String.format(displayedText, model.getFilteredStudentList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ViewGroupCommand // instanceof handles nulls
                && predicate.equals(((ViewGroupCommand) other).predicate)); // state check
    }

    public String getGroupInformation(Model model) {
        ObservableList<Group> groupList = model.getAddressBook().getGroupList();

        // Finds group in the grouplist that has the given group name
        for (Group group : groupList) {
            if (group.getGroupName().equals(groupName)) {
                GroupName groupName = group.getGroupName();
                Description description = group.getDescription();

                return String.format(Messages.MESSAGE_DISPLAY_GROUP_FORMAT, groupName, description);
            }
        }

        return Messages.MESSAGE_GROUP_NOT_FOUND;
    }
}
