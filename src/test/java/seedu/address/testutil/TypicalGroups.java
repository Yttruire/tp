package seedu.address.testutil;

import seedu.address.model.group.Group;

/**
 * A utility class containing a list of {@code Group} objects to be used in tests.
 */
public class TypicalGroups {
    public static final String TYPICAL_GROUP_CS2103T_NAME = "CS2103T";
    public static final String TYPICAL_GROUP_CS2103T_DESC = "A Software engineering module";

    public static final String TYPICAL_GROUP_CS2101_NAME = "CS2101";
    public static final String TYPICAL_GROUP_CS2101_DESC = "An effective communication module";

    public static final Group TYPICAL_GROUP_CS2103T = new GroupBuilder()
            .withGroupName(TYPICAL_GROUP_CS2103T_NAME).withDescription(TYPICAL_GROUP_CS2103T_DESC)
            .withTypicalStudents().build();

    public static final Group TYPICAL_GROUP_CS2101 = new GroupBuilder()
            .withGroupName(TYPICAL_GROUP_CS2101_NAME).withDescription(TYPICAL_GROUP_CS2101_DESC).build();
}
