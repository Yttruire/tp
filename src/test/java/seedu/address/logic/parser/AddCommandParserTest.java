package seedu.address.logic.parser;

//import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
//import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_AMY;
//import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_BOB;
//import static seedu.address.logic.commands.CommandTestUtil.GROUP_NAME_DESC_BOB;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_EMAIL_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_TELEGRAM_HANDLE_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_AMY;
//import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_BOB;
//import static seedu.address.logic.commands.CommandTestUtil.TELEGRAM_HANDLE_DESC_AMY;
//import static seedu.address.logic.commands.CommandTestUtil.TELEGRAM_HANDLE_DESC_BOB;
//import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
//import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_GROUP_NAME_BOB;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_TELEGRAM_HANDLE_BOB;
//import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
//import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
//import static seedu.address.testutil.TypicalStudents.BOB;
//
//import org.junit.jupiter.api.Test;
//
//import seedu.address.logic.commands.AddCommand;
//import seedu.address.model.student.Email;
//import seedu.address.model.student.Name;
//import seedu.address.model.student.TelegramHandle;
//import seedu.address.model.student.Student;
//import seedu.address.testutil.StudentBuilder;

public class AddCommandParserTest {
    private AddCommandParser parser = new AddCommandParser();

    //TODO Fix test case
    /*
    @Test
    public void parse_allFieldsPresent_success() {
        Student expectedStudent = new StudentBuilder(BOB).build();

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_BOB + TELEGRAM_HANDLE_DESC_BOB + EMAIL_DESC_BOB
                + GROUP_NAME_DESC_BOB, new AddCommand(expectedStudent));

        // multiple names - last name accepted
        assertParseSuccess(parser, NAME_DESC_AMY + NAME_DESC_BOB + TELEGRAM_HANDLE_DESC_BOB + EMAIL_DESC_BOB
                + GROUP_NAME_DESC_BOB, new AddCommand(expectedStudent));

        // multiple telegram handles - last telegram handle accepted
        assertParseSuccess(parser, NAME_DESC_BOB + TELEGRAM_HANDLE_DESC_AMY + TELEGRAM_HANDLE_DESC_BOB + EMAIL_DESC_BOB
                + GROUP_NAME_DESC_BOB, new AddCommand(expectedStudent));

        // multiple emails - last email accepted
        assertParseSuccess(parser, NAME_DESC_BOB + TELEGRAM_HANDLE_DESC_BOB + EMAIL_DESC_AMY + EMAIL_DESC_BOB
                + GROUP_NAME_DESC_BOB, new AddCommand(expectedStudent));
    }

    @Test
    public void parse_optionalFieldsMissing_success() {
        Student expectedStudent = new StudentBuilder(BOB).build();

        // multiple names - last name accepted
        assertParseSuccess(parser, NAME_DESC_AMY + NAME_DESC_BOB + TELEGRAM_HANDLE_DESC_BOB + EMAIL_DESC_BOB
            + GROUP_NAME_DESC_BOB, new AddCommand(expectedStudent));

        // multiple telegram handles - last telegram handle accepted
        assertParseSuccess(parser, NAME_DESC_BOB + TELEGRAM_HANDLE_DESC_AMY + TELEGRAM_HANDLE_DESC_BOB + EMAIL_DESC_BOB
            + GROUP_NAME_DESC_BOB, new AddCommand(expectedStudent));

        // multiple emails - last email accepted
        assertParseSuccess(parser, NAME_DESC_BOB + TELEGRAM_HANDLE_DESC_BOB + EMAIL_DESC_AMY + EMAIL_DESC_BOB
            + GROUP_NAME_DESC_BOB, new AddCommand(expectedStudent));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE);

        // missing name prefix
        assertParseFailure(parser, VALID_NAME_BOB + TELEGRAM_HANDLE_DESC_BOB + EMAIL_DESC_BOB + GROUP_NAME_DESC_BOB,
                expectedMessage);

        // missing telegram handle prefix
        assertParseFailure(parser, NAME_DESC_BOB + VALID_TELEGRAM_HANDLE_BOB + EMAIL_DESC_BOB + GROUP_NAME_DESC_BOB,
                expectedMessage);

        // missing email prefix
        assertParseFailure(parser, NAME_DESC_BOB + TELEGRAM_HANDLE_DESC_BOB + VALID_EMAIL_BOB + GROUP_NAME_DESC_BOB,
                expectedMessage);

        // all prefixes missing
        assertParseFailure(parser, VALID_NAME_BOB + VALID_TELEGRAM_HANDLE_BOB + VALID_EMAIL_BOB + VALID_GROUP_NAME_BOB,
                expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        //invalid name
        assertParseFailure(parser, INVALID_NAME_DESC + TELEGRAM_HANDLE_DESC_BOB + EMAIL_DESC_BOB + GROUP_NAME_DESC_BOB,
                Name.MESSAGE_CONSTRAINTS);

        // invalid telegram handle
        assertParseFailure(parser, NAME_DESC_BOB + INVALID_TELEGRAM_HANDLE_DESC + EMAIL_DESC_BOB + GROUP_NAME_DESC_BOB,
                TelegramHandle.MESSAGE_CONSTRAINTS);

        // invalid email
        assertParseFailure(parser, NAME_DESC_BOB + TELEGRAM_HANDLE_DESC_BOB + INVALID_EMAIL_DESC + GROUP_NAME_DESC_BOB,
                Email.MESSAGE_CONSTRAINTS);

        // two invalid values, only first invalid value reported
        assertParseFailure(parser, INVALID_NAME_DESC + TELEGRAM_HANDLE_DESC_BOB + EMAIL_DESC_BOB + GROUP_NAME_DESC_BOB,
                Name.MESSAGE_CONSTRAINTS);

        // non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + NAME_DESC_BOB + TELEGRAM_HANDLE_DESC_BOB + EMAIL_DESC_BOB
                        + GROUP_NAME_DESC_BOB,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
    }

     */
}
