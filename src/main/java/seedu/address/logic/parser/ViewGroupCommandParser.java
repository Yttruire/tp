package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.ViewGroupCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.group.GroupName;
import seedu.address.model.student.ContainsGroupNamePredicate;

public class ViewGroupCommandParser implements Parser<ViewGroupCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ViewGroupCommand
     * and returns a ViewGroupCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ViewGroupCommand parse(String args) throws ParseException {
        try {
            GroupName groupName = ParserUtil.parseGroupName(args);
            return new ViewGroupCommand(new ContainsGroupNamePredicate(groupName), groupName);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewGroupCommand.MESSAGE_USAGE), pe);
        }
    }
}
