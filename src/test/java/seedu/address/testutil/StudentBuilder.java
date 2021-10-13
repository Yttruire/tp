package seedu.address.testutil;

import seedu.address.model.group.Description;
import seedu.address.model.group.Group;
import seedu.address.model.group.GroupName;
import seedu.address.model.student.Email;
import seedu.address.model.student.Name;
import seedu.address.model.student.Student;
import seedu.address.model.student.TelegramHandle;

/**
 * A utility class to help with building Student objects.
 */
public class StudentBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_TELEGRAM_HANDLE = "@amy_bee";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_GROUP_NAME = "CS2103T";
    public static final String DEFAULT_DESCRIPTION = "software eng mod";

    private Name name;
    private TelegramHandle telegramHandle;
    private Email email;
    private Group group;

    /**
     * Creates a {@code StudentBuilder} with the default details.
     */
    public StudentBuilder() {
        name = new Name(DEFAULT_NAME);
        telegramHandle = new TelegramHandle(DEFAULT_TELEGRAM_HANDLE);
        email = new Email(DEFAULT_EMAIL);
        group = new Group(new GroupName(DEFAULT_GROUP_NAME), new Description(DEFAULT_DESCRIPTION));
    }

    /**
     * Initializes the StudentBuilder with the data of {@code studentToCopy}.
     */
    public StudentBuilder(Student studentToCopy) {
        name = studentToCopy.getName();
        telegramHandle = studentToCopy.getTelegramHandle();
        email = studentToCopy.getEmail();
        group = studentToCopy.getGroup();
    }

    /**
     * Sets the {@code Name} of the {@code Student} that we are building.
     */
    public StudentBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code TelegramHandle} of the {@code Student} that we are building.
     */
    public StudentBuilder withTelegramHandle(String telegramHandle) {
        this.telegramHandle = new TelegramHandle(telegramHandle);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Student} that we are building.
     */
    public StudentBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code GroupName} of the {@code Student} that we are building.
     */
    public StudentBuilder withGroup(String groupName, String description) {
        this.group = new Group(new GroupName(groupName), new Description(description));
        return this;
    }

    /**
     * Sets the {@code GroupName} of the {@code Student} that we are building.
     */
    public StudentBuilder withGroup(Group group) {
        this.group = new Group(new GroupName(group.getGroupName().toString()),
                new Description(group.getDescription().toString()));
        return this;
    }

    /**
     * Builds a student
     * @return built student
     */
    public Student build() {
        // TODO Double confirm, do we need to load a group from the model for this testUtil method/class?
        return new Student(name, telegramHandle, email, group);
    }

}
