package seedu.address.testutil;

import seedu.address.logic.commands.EditCommand.EditStudentDescriptor;
import seedu.address.model.group.Description;
import seedu.address.model.group.Group;
import seedu.address.model.group.GroupName;
import seedu.address.model.student.Email;
import seedu.address.model.student.Name;
import seedu.address.model.student.Student;
import seedu.address.model.student.TelegramHandle;

/**
 * A utility class to help with building EditStudentDescriptor objects.
 */
public class EditStudentDescriptorBuilder {

    private EditStudentDescriptor descriptor;

    public EditStudentDescriptorBuilder() {
        descriptor = new EditStudentDescriptor();
    }

    public EditStudentDescriptorBuilder(EditStudentDescriptor descriptor) {
        this.descriptor = new EditStudentDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditStudentDescriptor} with fields containing {@code student}'s details
     */
    public EditStudentDescriptorBuilder(Student student) {
        descriptor = new EditStudentDescriptor();
        descriptor.setName(student.getName());
        descriptor.setTelegramHandle(student.getTelegramHandle());
        descriptor.setEmail(student.getEmail());
    }

    /**
     * Sets the {@code Name} of the {@code EditStudentDescriptor} that we are building.
     */
    public EditStudentDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code TelegramHandle} of the {@code EditStudentDescriptor} that we are building.
     */
    public EditStudentDescriptorBuilder withTelegramHandle(String telegramHandle) {
        descriptor.setTelegramHandle(new TelegramHandle(telegramHandle));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditStudentDescriptor} that we are building.
     */
    public EditStudentDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code GroupName} of the {@code EditStudentDescriptor} that we are building.
     */
    public EditStudentDescriptorBuilder withGroup(Group group) {
        descriptor.setGroup(group);
        return this;
    }

    /**
     * Sets the {@code GroupName} of the {@code EditStudentDescriptor} that we are building.
     */
    public EditStudentDescriptorBuilder withGroup(String groupName, String description) {
        descriptor.setGroup(new Group(new GroupName(groupName), new Description(description)));
        return this;
    }


    public EditStudentDescriptor build() {
        return descriptor;
    }
}
