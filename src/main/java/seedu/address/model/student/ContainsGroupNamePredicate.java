package seedu.address.model.student;

import java.util.function.Predicate;

import seedu.address.model.group.GroupName;

public class ContainsGroupNamePredicate implements Predicate<Student> {

    private final GroupName groupName;

    public ContainsGroupNamePredicate(GroupName groupName) {
        this.groupName = groupName;
    }

    @Override
    public boolean test(Student student) {
        //TODO : Change student.getGroup().getGroupName() to student.getGroupName() once we change student group field
        return groupName.equals(student.getGroup().getGroupName());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ContainsGroupNamePredicate // instanceof handles nulls
                && groupName.equals(((ContainsGroupNamePredicate) other).groupName)); // state check
    }
}
