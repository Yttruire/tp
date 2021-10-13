package seedu.address.model.util;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.group.Description;
import seedu.address.model.group.Group;
import seedu.address.model.group.GroupName;
import seedu.address.model.student.Email;
import seedu.address.model.student.Name;
import seedu.address.model.student.Student;
import seedu.address.model.student.TelegramHandle;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Student[] getSampleStudents() {
        return new Student[]{
            new Student(new Name("Alex Yeoh"), new TelegramHandle("@alex_yeoh"), new Email("alexyeoh@example.com"),
                new Group(new GroupName("CS2103T"), new Description("SWE Module"))),
            new Student(new Name("Bernice Yu"), new TelegramHandle("@bernice_yu"), new Email("berniceyu@example.com"),
                new Group(new GroupName("CS2103T"), new Description("SWE Module"))),
            new Student(new Name("Charlotte Oliveiro"), new TelegramHandle("@charlotte"),
                    new Email("charlotte@example.com"), new Group(new GroupName("CS2103T"),
                    new Description("SWE Module"))),
            new Student(new Name("David Li"), new TelegramHandle("@david_li"), new Email("lidavid@example.com"),
                new Group(new GroupName("CS2103T"), new Description("SWE Module"))),
            new Student(new Name("Irfan Ibrahim"), new TelegramHandle("@irfan_ibrahim"), new Email("irfan@example.com"),
                new Group(new GroupName("CS2103T"), new Description("SWE Module"))),
            new Student(new Name("Roy Balakrishnan"), new TelegramHandle("@roy_balakrishnan"),
                    new Email("royb@example.com"), new Group(new GroupName("CS2103T"), new Description("SWE Module")))
        };
    }

    private static Group[] getSampleGroups() {
        return new Group[]{
            new Group(new GroupName("CS2103T"), new Description("SWE Module")),
            new Group(new GroupName("CS2101"), new Description("test"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Student sampleStudent : getSampleStudents()) {
            sampleAb.addStudent(sampleStudent);
        }

        for (Group sampleGroup : getSampleGroups()) {
            sampleAb.addGroup(sampleGroup);
        }

        return sampleAb;
    }
}
