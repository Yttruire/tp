package seedu.address.model.student;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.model.group.GroupName;
import seedu.address.testutil.StudentBuilder;

class ContainsGroupNamePredicateTest {

    @Test
    public void equals() {
        GroupName firstGroupName = new GroupName("CS2103T");
        GroupName secondGroupName = new GroupName("CS2101");

        ContainsGroupNamePredicate firstPredicate = new ContainsGroupNamePredicate(firstGroupName);
        ContainsGroupNamePredicate secondPredicate = new ContainsGroupNamePredicate(secondGroupName);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        ContainsGroupNamePredicate firstPredicateCopy = new ContainsGroupNamePredicate(firstGroupName);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different predicate -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_containsGroupName_returnsTrue() {
        ContainsGroupNamePredicate predicate = new ContainsGroupNamePredicate(new GroupName("CS2103T"));
        assertTrue(predicate.test(new StudentBuilder().withName("Alice")
                .withGroup("CS2103T", "test").build()));
    }

    @Test
    public void test_doesNotContainsGroupName_returnsFalse() {
        ContainsGroupNamePredicate predicate = new ContainsGroupNamePredicate(new GroupName("CS2103T"));
        assertFalse(predicate.test(new StudentBuilder().withName("Alice")
                .withGroup("GEQ1000", "test").build()));
    }

}
