package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_GROUP_DESCRIPTION_CS1101S;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GROUP_DESCRIPTION_CS1231S;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GROUP_DESCRIPTION_CS2030S;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GROUP_DESCRIPTION_CS2040S;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GROUP_NAME_CS1101S;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GROUP_NAME_CS1231S;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GROUP_NAME_CS2030S;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GROUP_NAME_CS2040S;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.group.Group;


public class TypicalGroup {
    public static final Group DEFAULT_GROUP = new GroupBuilder().withSampleStudents().build();
    public static final Group CS1231S = new GroupBuilder().withGroupName(VALID_GROUP_NAME_CS1231S)
            .withDescription(VALID_GROUP_DESCRIPTION_CS1231S).withSampleStudents().build();
    public static final Group CS1101S = new GroupBuilder().withGroupName(VALID_GROUP_NAME_CS1101S)
            .withDescription(VALID_GROUP_DESCRIPTION_CS1101S).withSampleStudents().build();
    public static final Group CS2030S = new GroupBuilder().withGroupName(VALID_GROUP_NAME_CS2030S)
            .withDescription(VALID_GROUP_DESCRIPTION_CS2030S).withSampleStudents().build();
    public static final Group CS2040S = new GroupBuilder().withGroupName(VALID_GROUP_NAME_CS2040S)
            .withDescription(VALID_GROUP_DESCRIPTION_CS2040S).withSampleStudents().build();

    private TypicalGroup() {} // prevents instantiation

    public static AddressBook getTypicalAddressBook() {
        AddressBook csb = new AddressBook();
        for (Group group : getTypicalGroups()) {
            csb.addGroup(group);
        }
        return csb;
    }

    public static List<Group> getTypicalGroups() {
        return new ArrayList<>(Arrays.asList(DEFAULT_GROUP, CS1231S, CS1101S, CS2030S, CS2040S));
    }
}
