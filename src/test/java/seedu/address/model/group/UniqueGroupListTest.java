package seedu.address.model.group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalGroups.TYPICAL_GROUP_CS2101;
import static seedu.address.testutil.TypicalGroups.TYPICAL_GROUP_CS2103T;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.group.exceptions.DuplicateGroupException;
import seedu.address.model.group.exceptions.GroupNotFoundException;
import seedu.address.testutil.GroupBuilder;

public class UniqueGroupListTest {

    private final UniqueGroupList uniqueGroupList = new UniqueGroupList();

    @Test
    public void contains_nullGroup_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueGroupList.contains(null));
    }

    @Test
    public void contains_groupNotInList_returnsFalse() {
        assertFalse(uniqueGroupList.contains(TYPICAL_GROUP_CS2103T));
    }

    @Test
    public void contains_groupInList_returnsTrue() {
        uniqueGroupList.add(TYPICAL_GROUP_CS2103T);
        assertTrue(uniqueGroupList.contains(TYPICAL_GROUP_CS2103T));
    }

    @Test
    public void contains_groupWithSameIdentityFieldsInList_returnsTrue() {
        uniqueGroupList.add(TYPICAL_GROUP_CS2103T);
        Group editedGroup = new GroupBuilder(TYPICAL_GROUP_CS2103T).build();
        assertTrue(uniqueGroupList.contains(editedGroup));
    }

    @Test
    public void add_nullGroup_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueGroupList.add(null));
    }

    @Test
    public void add_duplicateGroup_throwsDuplicateGroupException() {
        uniqueGroupList.add(TYPICAL_GROUP_CS2103T);
        assertThrows(DuplicateGroupException.class, () -> uniqueGroupList.add(TYPICAL_GROUP_CS2103T));
    }

    @Test
    public void setGroup_nullTargetGroup_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueGroupList.setGroup(null, TYPICAL_GROUP_CS2103T));
    }

    @Test
    public void setGroup_nullEditedGroup_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueGroupList.setGroup(TYPICAL_GROUP_CS2103T, null));
    }

    @Test
    public void setGroup_targetGroupNotInList_throwsGroupNotFoundException() {
        assertThrows(GroupNotFoundException.class, () ->
                uniqueGroupList.setGroup(TYPICAL_GROUP_CS2103T, TYPICAL_GROUP_CS2103T));
    }

    @Test
    public void setGroup_editedGroupIsSameGroup_success() {
        uniqueGroupList.add(TYPICAL_GROUP_CS2103T);
        uniqueGroupList.setGroup(TYPICAL_GROUP_CS2103T, TYPICAL_GROUP_CS2103T);
        UniqueGroupList expectedUniqueGroupList = new UniqueGroupList();
        expectedUniqueGroupList.add(TYPICAL_GROUP_CS2103T);
        assertEquals(expectedUniqueGroupList, uniqueGroupList);
    }

    @Test
    public void setGroup_editedGroupHasSameIdentity_success() {
        uniqueGroupList.add(TYPICAL_GROUP_CS2103T);
        Group editedGroup = new GroupBuilder(TYPICAL_GROUP_CS2103T).build();
        uniqueGroupList.setGroup(TYPICAL_GROUP_CS2103T, editedGroup);
        UniqueGroupList expectedUniqueGroupList = new UniqueGroupList();
        expectedUniqueGroupList.add(editedGroup);
        assertEquals(expectedUniqueGroupList, uniqueGroupList);
    }

    @Test
    public void setGroup_editedGroupHasDifferentIdentity_success() {
        uniqueGroupList.add(TYPICAL_GROUP_CS2103T);
        uniqueGroupList.setGroup(TYPICAL_GROUP_CS2103T, TYPICAL_GROUP_CS2101);
        UniqueGroupList expectedUniqueGroupList = new UniqueGroupList();
        expectedUniqueGroupList.add(TYPICAL_GROUP_CS2101);
        assertEquals(expectedUniqueGroupList, uniqueGroupList);
    }

    @Test
    public void setGroup_editedGroupHasNonUniqueIdentity_throwsDuplicateGroupException() {
        uniqueGroupList.add(TYPICAL_GROUP_CS2103T);
        uniqueGroupList.add(TYPICAL_GROUP_CS2101);
        assertThrows(DuplicateGroupException.class, () ->
                uniqueGroupList.setGroup(TYPICAL_GROUP_CS2103T, TYPICAL_GROUP_CS2101));
    }

    @Test
    public void remove_nullGroup_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueGroupList.remove(null));
    }

    @Test
    public void remove_groupDoesNotExist_throwsGroupNotFoundException() {
        assertThrows(GroupNotFoundException.class, () -> uniqueGroupList.remove(TYPICAL_GROUP_CS2103T));
    }

    @Test
    public void remove_existingGroup_removesGroup() {
        uniqueGroupList.add(TYPICAL_GROUP_CS2103T);
        uniqueGroupList.remove(TYPICAL_GROUP_CS2103T);
        UniqueGroupList expectedUniqueGroupList = new UniqueGroupList();
        assertEquals(expectedUniqueGroupList, uniqueGroupList);
    }

    @Test
    public void setGroups_nullUniqueGroupList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueGroupList.setGroup((UniqueGroupList) null));
    }

    @Test
    public void setGroups_uniqueGroupList_replacesOwnListWithProvidedUniqueGroupList() {
        uniqueGroupList.add(TYPICAL_GROUP_CS2103T);
        UniqueGroupList expectedUniqueGroupList = new UniqueGroupList();
        expectedUniqueGroupList.add(TYPICAL_GROUP_CS2101);
        uniqueGroupList.setGroup(expectedUniqueGroupList);
        assertEquals(expectedUniqueGroupList, uniqueGroupList);
    }

    @Test
    public void setGroups_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueGroupList.setGroup((List<Group>) null));
    }

    @Test
    public void setGroups_list_replacesOwnListWithProvidedList() {
        uniqueGroupList.add(TYPICAL_GROUP_CS2103T);
        List<Group> groupList = Collections.singletonList(TYPICAL_GROUP_CS2101);
        uniqueGroupList.setGroup(groupList);
        UniqueGroupList expectedUniqueGroupList = new UniqueGroupList();
        expectedUniqueGroupList.add(TYPICAL_GROUP_CS2101);
        assertEquals(expectedUniqueGroupList, uniqueGroupList);
    }

    @Test
    public void setGroups_listWithDuplicateGroups_throwsDuplicateGroupException() {
        List<Group> listWithDuplicateGroups = Arrays.asList(TYPICAL_GROUP_CS2103T, TYPICAL_GROUP_CS2103T);
        assertThrows(DuplicateGroupException.class, () -> uniqueGroupList.setGroup(listWithDuplicateGroups));
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () ->
                uniqueGroupList.asUnmodifiableObservableList().remove(0));
    }
}
