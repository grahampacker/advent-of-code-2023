package day1.calibrator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class CalibrationInputTest {

    @Test
    public void creating_null_calibration_input_should_throw_exception() {
        assertThrowsExactly(RuntimeException.class, () -> new CalibrationInput(null));
    }

    @Test
    public void creating_calibration_input_with_empty_string_should_throw_exception() {
        assertThrowsExactly(RuntimeException.class, () -> new CalibrationInput(""));
    }

    @Test
    public void creating_calibration_input_with_valid_value_stores_input() {
        String input = "81four8xkttczb2vj";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals(input, calibrationInput.getInputValue());
    }

    @Test
    public void exception_thrown_when_getting_first_number_when_none_exists() {
        String input = "ghshsdrhgaehraerh";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertThrowsExactly(RuntimeException.class, calibrationInput::getFirstNumberInInput);
    }

    @Test
    public void find_first_number_when_at_start_of_input() {
        String input = "5grthuiguireguire";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("5", calibrationInput.getFirstNumberInInput());
    }

    @Test
    public void find_first_number_when_at_end_of_input() {
        String input = "kjbvhkhegijhbiurb8";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("8", calibrationInput.getFirstNumberInInput());
    }

    @Test
    public void find_first_number_when_in_middle_of_input() {
        String input = "oqdwqojdw9lvkjvklv";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("9", calibrationInput.getFirstNumberInInput());
    }

    @Test
    public void find_first_number_when_multiple_numbers_in_input() {
        String input = "efheuif6kflewjf9lfekwjfe2klsejfioe8";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("6", calibrationInput.getFirstNumberInInput());
    }

    @Test
    public void exception_thrown_when_getting_last_number_when_none_exists() {
        String input = "ghshsdrhgaehraerh";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertThrowsExactly(RuntimeException.class, calibrationInput::getLastNumberInInput);
    }

    @Test
    public void find_last_number_when_at_start_of_input() {
        String input = "5grthuiguireguire";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("5", calibrationInput.getLastNumberInInput());
    }

    @Test
    public void find_last_number_when_at_end_of_input() {
        String input = "kjbvhkhegijhbiurb8";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("8", calibrationInput.getLastNumberInInput());
    }

    @Test
    public void find_last_number_when_in_middle_of_input() {
        String input = "oqdwqojdw9lvkjvklv";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("9", calibrationInput.getLastNumberInInput());
    }

    @Test
    public void find_last_number_when_multiple_numbers_in_input() {
        String input = "efheuif6kflewjf9lfekwjfe2klsejfioe8";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("8", calibrationInput.getLastNumberInInput());
    }

    @Test
    public void throw_exception_when_no_number_in_input_when_getting_upgraded_first_number() {
        String input = "bhsiuboltbstbtuitbh";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertThrowsExactly(RuntimeException.class, calibrationInput::getFirstNumberInInputUpgraded);
    }

    @Test
    public void finds_first_number_when_number_is_numeric() {
        String input = "bh4siuboltbstbtuitbh";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("4", calibrationInput.getFirstNumberInInputUpgraded());
    }

    @Test
    public void finds_first_number_when_number_is_numeric_with_multiple_numbers_in_input() {
        String input = "bh7siubol3tbs3tbtui3tbh";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("7", calibrationInput.getFirstNumberInInputUpgraded());
    }

    @Test
    public void finds_first_number_when_number_is_written_out() {
        String input = "bhfivesiuboltbstbtuitbh";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("5", calibrationInput.getFirstNumberInInputUpgraded());
    }

    @Test
    public void finds_first_number_when_number_is_written_out_with_multiple_numbers_in_input() {
        String input = "bsevenhfivesiuboltbstninebtuitbh";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("7", calibrationInput.getFirstNumberInInputUpgraded());
    }

    @Test
    public void finds_first_number_when_input_types_are_mixed_numeric_first() {
        String input = "b1sevenhfivesiuboltb4stninebtui8tbh";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("1", calibrationInput.getFirstNumberInInputUpgraded());
    }

    @Test
    public void finds_first_number_when_input_types_are_mixed_written_out_first() {
        String input = "btwo1sevenhfives4iuboltbstninebtui4tbh";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("2", calibrationInput.getFirstNumberInInputUpgraded());
    }


    @Test
    public void throw_exception_when_no_number_in_input_when_getting_upgraded_last_number() {
        String input = "bhsiuboltbstbtuitbh";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertThrowsExactly(RuntimeException.class, calibrationInput::getLastNumberInInputUpgraded);
    }

    @Test
    public void finds_last_number_when_number_is_numeric() {
        String input = "bh4siuboltbstbtuitbh";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("4", calibrationInput.getLastNumberInInputUpgraded());
    }

    @Test
    public void finds_last_number_when_number_is_numeric_with_multiple_numbers_in_input() {
        String input = "bh7siubol3tbs3tbtui3tbh";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("3", calibrationInput.getLastNumberInInputUpgraded());
    }

    @Test
    public void finds_last_number_when_number_is_written_out() {
        String input = "bhfivesiuboltbstbtuitbh";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("5", calibrationInput.getLastNumberInInputUpgraded());
    }

    @Test
    public void finds_last_number_when_number_is_written_out_with_multiple_numbers_in_input() {
        String input = "bsevenhfivesiuboltbstninebtuitbh";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("9", calibrationInput.getLastNumberInInputUpgraded());
    }

    @Test
    public void finds_last_number_when_input_types_are_mixed_numeric_last() {
        String input = "b1sevenhfivesiuboltb4stninebtui4tbh";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("4", calibrationInput.getLastNumberInInputUpgraded());
    }

    @Test
    public void finds_last_number_when_input_types_are_mixed_written_out_last() {
        String input = "btwo1sevenhfives4iuboltbstninebtuitbh";
        CalibrationInput calibrationInput = new CalibrationInput(input);
        assertEquals("9", calibrationInput.getLastNumberInInputUpgraded());
    }
}