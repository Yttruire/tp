package seedu.address.storage;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedStudent.MESSAGE_GROUP_NAME_NOT_FOUND;
import static seedu.address.storage.JsonAdaptedStudent.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalStudents.BENSON;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.group.Description;
import seedu.address.model.group.Group;
import seedu.address.model.group.GroupName;
import seedu.address.model.student.Email;
import seedu.address.model.student.Name;
import seedu.address.model.student.TelegramHandle;

public class JsonAdaptedStudentTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_TELEGRAM_HANDLE = "@rac";
    private static final String INVALID_EMAIL = "example.com";

    private static final String VALID_NAME = BENSON.getName().toString();
    private static final String VALID_TELEGRAM_HANDLE = BENSON.getTelegramHandle().toString();
    private static final String VALID_EMAIL = BENSON.getEmail().toString();
    private static final String VALID_GROUP_NAME = BENSON.getGroup().getGroupName().toString();
    private static final String VALID_DESCRIPTION = "A Software engineering module";

    //TODO Fix test case
    /*
    @Test
    public void toModelType_validStudentDetails_returnsStudent() throws Exception {
        JsonAdaptedStudent student = new JsonAdaptedStudent(BENSON);
        assertEquals(BENSON, student.toModelType());
    }

     */

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        ObservableList<Group> groupList = FXCollections.observableArrayList();
        groupList.add(new Group(new GroupName(VALID_GROUP_NAME), new Description(VALID_DESCRIPTION)));
        JsonAdaptedStudent student =
                new JsonAdaptedStudent(INVALID_NAME, VALID_TELEGRAM_HANDLE, VALID_EMAIL, VALID_GROUP_NAME);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, () -> student.toModelType(groupList));
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        ObservableList<Group> groupList = FXCollections.observableArrayList();
        groupList.add(new Group(new GroupName(VALID_GROUP_NAME), new Description(VALID_DESCRIPTION)));
        JsonAdaptedStudent student = new JsonAdaptedStudent(null, VALID_TELEGRAM_HANDLE, VALID_EMAIL, VALID_GROUP_NAME);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, () -> student.toModelType(groupList));
    }

    @Test
    public void toModelType_invalidTelegramHandle_throwsIllegalValueException() {
        ObservableList<Group> groupList = FXCollections.observableArrayList();
        groupList.add(new Group(new GroupName(VALID_GROUP_NAME), new Description(VALID_DESCRIPTION)));
        JsonAdaptedStudent student =
                new JsonAdaptedStudent(VALID_NAME, INVALID_TELEGRAM_HANDLE, VALID_EMAIL, VALID_GROUP_NAME);
        String expectedMessage = TelegramHandle.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, () -> student.toModelType(groupList));
    }

    @Test
    public void toModelType_nullTelegramHandle_throwsIllegalValueException() {
        ObservableList<Group> groupList = FXCollections.observableArrayList();
        groupList.add(new Group(new GroupName(VALID_GROUP_NAME), new Description(VALID_DESCRIPTION)));
        JsonAdaptedStudent student = new JsonAdaptedStudent(VALID_NAME, null, VALID_EMAIL, VALID_GROUP_NAME);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, TelegramHandle.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, () -> student.toModelType(groupList));
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        ObservableList<Group> groupList = FXCollections.observableArrayList();
        groupList.add(new Group(new GroupName(VALID_GROUP_NAME), new Description(VALID_DESCRIPTION)));
        JsonAdaptedStudent student =
                new JsonAdaptedStudent(VALID_NAME, VALID_TELEGRAM_HANDLE, INVALID_EMAIL, VALID_GROUP_NAME);
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, () -> student.toModelType(groupList));
    }

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        ObservableList<Group> groupList = FXCollections.observableArrayList();
        groupList.add(new Group(new GroupName(VALID_GROUP_NAME), new Description(VALID_DESCRIPTION)));
        JsonAdaptedStudent student = new JsonAdaptedStudent(VALID_NAME, VALID_TELEGRAM_HANDLE, null, VALID_GROUP_NAME);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, () -> student.toModelType(groupList));
    }

    @Test
    public void toModelType_nullGroupName_throwsIllegalValueException() {
        ObservableList<Group> groupList = FXCollections.observableArrayList();
        groupList.add(new Group(new GroupName(VALID_GROUP_NAME), new Description(VALID_DESCRIPTION)));
        JsonAdaptedStudent student = new JsonAdaptedStudent(VALID_NAME, VALID_TELEGRAM_HANDLE, VALID_EMAIL, null);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, GroupName.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, () -> student.toModelType(groupList));

    }

    @Test
    public void toModelType_noMatchingGroupNameInGroupList_throwsIllegalValueException() {
        ObservableList<Group> groupList = FXCollections.observableArrayList();
        JsonAdaptedStudent student = new JsonAdaptedStudent(VALID_NAME, VALID_TELEGRAM_HANDLE,
                VALID_EMAIL, VALID_GROUP_NAME);
        String expectedMessage = MESSAGE_GROUP_NAME_NOT_FOUND;
        assertThrows(IllegalValueException.class, expectedMessage, () -> student.toModelType(groupList));
    }

}
