package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GROUP_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GROUP_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TELEGRAM_HANDLE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TELEGRAM_HANDLE_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.group.Description;
import seedu.address.model.group.Group;
import seedu.address.model.group.GroupName;
import seedu.address.model.student.Student;

/**
 * A utility class containing a list of {@code Student} objects to be used in tests.
 */
public class TypicalStudents {

    public static final GroupName TYPICAL_GROUP_GROUPNAME = new GroupName("CS2103T");
    public static final Description TYPICAL_GROUP_DESCRIPTION = new Description("hi");
    public static final Group TYPICAL_GROUP = new Group(TYPICAL_GROUP_GROUPNAME, TYPICAL_GROUP_DESCRIPTION);

    public static final Student ALICE = new StudentBuilder().withName("Alice Pauline").withEmail("alice@example.com")
            .withGroup(TYPICAL_GROUP).withTelegramHandle("@alice_pauline").build();
    public static final Student BENSON = new StudentBuilder().withName("Benson Meier").withEmail("johnd@example.com")
            .withGroup(TYPICAL_GROUP).withTelegramHandle("@benson_meier").build();
    public static final Student CARL = new StudentBuilder().withName("Carl Kurz").withTelegramHandle("@carl_kurz")
            .withEmail("heinz@example.com").withGroup(TYPICAL_GROUP).build();
    public static final Student DANIEL = new StudentBuilder().withName("Daniel Meier")
            .withTelegramHandle("@daniel_meier").withEmail("cornelia@example.com").withGroup(TYPICAL_GROUP).build();
    public static final Student ELLE = new StudentBuilder().withName("Elle Meyer").withTelegramHandle("@elle_meyer")
            .withEmail("werner@example.com").withGroup(TYPICAL_GROUP).build();
    public static final Student FIONA = new StudentBuilder().withName("Fiona Kunz").withTelegramHandle("@fiona_kunz")
            .withEmail("lydia@example.com").withGroup(TYPICAL_GROUP).build();
    public static final Student GEORGE = new StudentBuilder().withName("George Best").withTelegramHandle("@george_best")
            .withEmail("anna@example.com").withGroup(TYPICAL_GROUP).build();

    // Manually added
    public static final Student HOON = new StudentBuilder().withName("Hoon Meier").withTelegramHandle("@hoon_meier")
            .withEmail("stefan@example.com").withGroup(TYPICAL_GROUP).build();
    public static final Student IDA = new StudentBuilder().withName("Ida Mueller").withTelegramHandle("@ida_mueller")
            .withEmail("hans@example.com").withGroup(TYPICAL_GROUP).build();

    // Manually added - Student's details found in {@code CommandTestUtil}
    public static final Student AMY = new StudentBuilder().withName(VALID_NAME_AMY)
            .withTelegramHandle(VALID_TELEGRAM_HANDLE_AMY).withEmail(VALID_EMAIL_AMY)
            .withGroup(VALID_GROUP_NAME_AMY, VALID_DESC_AMY).build();
    public static final Student BOB = new StudentBuilder().withName(VALID_NAME_BOB)
            .withTelegramHandle(VALID_TELEGRAM_HANDLE_BOB).withEmail(VALID_EMAIL_BOB)
            .withGroup(VALID_GROUP_NAME_BOB, VALID_DESC_BOB).build();

    //TODO GroupBuilder in the future?

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalStudents() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical students.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Student student : getTypicalStudents()) {
            ab.addStudent(student);
        }

        for (Group group : getTypicalGroups()) {
            ab.addGroup(group);
        }

        return ab;
    }

    public static List<Student> getTypicalStudents() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }

    public static List<Group> getTypicalGroups() {
        return new ArrayList<>(List.of(GROUPCS2103T));
    }
}
