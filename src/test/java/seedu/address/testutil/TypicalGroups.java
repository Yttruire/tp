package seedu.address.testutil;

import seedu.address.model.group.Group;

/**
 * A utility class containing a list of {@code Group} objects to be used in tests.
 */
public class TypicalGroups {

    public static final Group TYPICAL_GROUP_CS2103T = new GroupBuilder()
            .withGroupName("CS2103T").withDescription("hi").build();
    public static final Group TYPICAL_GROUP_CS2101 = new GroupBuilder()
            .withGroupName("CS2101").withDescription("hi").build();
}
