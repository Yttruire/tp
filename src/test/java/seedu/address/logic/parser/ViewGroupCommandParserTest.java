package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ViewGroupCommand;
import seedu.address.model.group.Group;
import seedu.address.model.student.ContainsGroupNamePredicate;
import seedu.address.testutil.TypicalGroups;

public class ViewGroupCommandParserTest {

    private ViewGroupCommandParser parser = new ViewGroupCommandParser();

    private Group group = TypicalGroups.TYPICAL_GROUP_CS2103T;

    private String validGroupName = group.getGroupName().toString();

    private ContainsGroupNamePredicate predicate = new ContainsGroupNamePredicate(group.getGroupName());

    @Test
    public void parser_validArgs_returnsViewGroupCommand() {
        assertParseSuccess(parser, validGroupName, new ViewGroupCommand(predicate, group.getGroupName()));
    }

    @Test
    public void parser_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "  ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewGroupCommand.MESSAGE_USAGE));
    }
}
