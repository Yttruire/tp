package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalStudents.getTypicalAddressBook;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.group.Description;
import seedu.address.model.group.Group;
import seedu.address.model.group.GroupName;
import seedu.address.model.student.ContainsGroupNamePredicate;
import seedu.address.model.student.Student;
import seedu.address.testutil.StudentBuilder;

public class ViewGroupCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        List<Group> testGroups = Arrays.asList(new Group(new GroupName("CS2103T"), new Description("SWE Module")));
        Student validStudent1 = new StudentBuilder().withName("Erin")
                .withGroup("CS2103T", "SWE Module").build();
        Student validStudent2 = new StudentBuilder().withName("Monkey")
                .withGroup("CS2103T", "SWE Module").build();
        Student validStudent3 = new StudentBuilder().withName("Pei Xian")
                .withGroup("CS2101", "SWE Module").build();
        List<Student> testStudents = Arrays.asList(validStudent1, validStudent2, validStudent3);
        AddressBook addressBook = getTypicalAddressBook();
        addressBook.setGroups(testGroups);
        addressBook.setStudents(testStudents);
        model = new ModelManager(addressBook, new UserPrefs());
        expectedModel = new ModelManager(addressBook, new UserPrefs());
    }

    @Test
    public void execute_groupExists_displaysStudentsInGroup() {
        ContainsGroupNamePredicate predicate = new ContainsGroupNamePredicate(new GroupName("CS2103T"));
        expectedModel.updateFilteredStudentList(predicate);
        String successMessage = String.format(Messages.MESSAGE_DISPLAY_GROUP_FORMAT, "CS2103T", "SWE Module") + "\n"
                                + String.format(Messages.MESSAGE_STUDENTS_LISTED_OVERVIEW, 2);

        assertCommandSuccess(new ViewGroupCommand(predicate, new GroupName("CS2103T")), model,
                successMessage, expectedModel);
    }

    @Test
    public void execute_groupDoesNotExist_displaysGroupNotFoundMessage() {
        ContainsGroupNamePredicate predicate = new ContainsGroupNamePredicate(new GroupName("CS2100"));
        expectedModel.updateFilteredStudentList(predicate);
        String feedbackMessage = Messages.MESSAGE_GROUP_NOT_FOUND + "\n"
                + String.format(Messages.MESSAGE_STUDENTS_LISTED_OVERVIEW, 0);
        assertCommandSuccess(new ViewGroupCommand(predicate, new GroupName("CS2100")), model,
                feedbackMessage, expectedModel);
    }

}
