package seedu.address.model.group;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.GroupBuilder;

public class GroupContainsKeywordsPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        GroupContainsKeywordsPredicate firstPredicate = new GroupContainsKeywordsPredicate(firstPredicateKeywordList);
        GroupContainsKeywordsPredicate secondPredicate = new GroupContainsKeywordsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        GroupContainsKeywordsPredicate firstPredicateCopy =
                new GroupContainsKeywordsPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different student -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_groupNameContainsKeywords_returnsTrue() {
        // One keyword
        GroupContainsKeywordsPredicate predicate =
                new GroupContainsKeywordsPredicate(Collections.singletonList("CS2103T"));
        assertTrue(predicate.test(new GroupBuilder().withGroupName("CS2103T").build()));

        // Only one matching keyword
        // Note, predicate can have more than one keyword, but groupName can only contain a single word
        predicate = new GroupContainsKeywordsPredicate(Arrays.asList("CS2101", "CS2103T"));
        assertTrue(predicate.test(new GroupBuilder().withGroupName("CS2103T").build()));

        // Mixed-case keywords
        predicate = new GroupContainsKeywordsPredicate(Arrays.asList("cS2103t", "tUtOrIAl"));
        assertTrue(predicate.test(new GroupBuilder().withGroupName("CS2103T").build()));
    }

    @Test
    public void test_groupNameDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        GroupContainsKeywordsPredicate predicate = new GroupContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(new GroupBuilder().withGroupName("CS2103T").build()));

        // Non-matching keyword
        predicate = new GroupContainsKeywordsPredicate(Arrays.asList("CS2101"));
        assertFalse(predicate.test(new GroupBuilder().withGroupName("CS2103T").build()));

        // Keywords match description, but does not match name
        predicate = new GroupContainsKeywordsPredicate(Arrays.asList("softwareengineering"));
        assertFalse(predicate.test(new GroupBuilder().withGroupName("CS2103T")
                .withDescription("softwareengineering").build()));
    }
}
