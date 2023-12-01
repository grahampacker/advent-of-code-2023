package day1.calibrator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class CalibratorTest {

    @Test
    public void calibrator_throws_exception_when_null_input_provided() {
        assertThrowsExactly(RuntimeException.class, () -> new Calibrator(null));
    }

    @Test
    public void calibrator_throws_exception_when_empty_input_provided() {
        assertThrowsExactly(RuntimeException.class, () -> new Calibrator(""));
    }

    @Test
    public void calibrator_stores_calibrator_input_for_one_line_of_input() {
        String input = "igjierojgioerjgiore";
        Calibrator calibrator = new Calibrator(input);
        assertEquals(1, calibrator.getCalibratorInput().size());
        assertEquals(input, calibrator.getCalibratorInput().get(0).getInputValue());
    }

    @Test
    public void calibrator_strores_calibrator_inputs_for_multiple_lines_of_input() {
        String input = "igjierojgioerjgiore\nrguhreuighrgu\neriuhgeurgh";
        Calibrator calibrator = new Calibrator(input);
        assertEquals(3, calibrator.getCalibratorInput().size());
        assertEquals("igjierojgioerjgiore", calibrator.getCalibratorInput().get(0).getInputValue());
        assertEquals("rguhreuighrgu", calibrator.getCalibratorInput().get(1).getInputValue());
        assertEquals("eriuhgeurgh", calibrator.getCalibratorInput().get(2).getInputValue());
    }

    @Test
    public void calibrator_creates_list_of_calibration_values_from_one_input() {
        String input = "igji2erojgioerjgi5ore";
        Calibrator calibrator = new Calibrator(input);
        List<Integer> result = calibrator.getCalibrationValues();
        assertEquals(1, result.size());
        assertEquals(25, result.get(0));
    }

    @Test
    public void calibrator_creates_list_of_calibration_values_from_multiple_inputs() {
        String input = "igj3ierojgioerjgi5ore\nrguh1reuigh7rgu\neriuhgeur8gh";
        Calibrator calibrator = new Calibrator(input);
        List<Integer> result = calibrator.getCalibrationValues();
        assertEquals(3, result.size());
        assertEquals(35, result.get(0));
        assertEquals(17, result.get(1));
        assertEquals(88, result.get(2));
    }

    @Test
    public void get_total_calibration_value_for_one_input() {
        String input = "igji2erojgioerjgi5ore";
        Calibrator calibrator = new Calibrator(input);
        assertEquals(25, calibrator.getCalibrationValue());
    }

    @Test
    public void get_total_calibration_value_for_multiple_inputs() {
        String input = "igj3ierojgioerjgi5ore\nrguh1reuigh7rgu\neriuhgeur8gh";
        Calibrator calibrator = new Calibrator(input);
        assertEquals(140, calibrator.getCalibrationValue());
    }

    @Test
    public void get_total_calibration_value_from_provided_test_input() {
        String input = """
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet""";
        Calibrator calibrator = new Calibrator(input);
        assertEquals(142, calibrator.getCalibrationValue());
    }

    @Test
    public void calibrator_creates_list_of_upgraded_calibration_values_from_one_input() {
        String input = "igsevenji2erojgioerjgi5otwore";
        Calibrator calibrator = new Calibrator(input);
        List<Integer> result = calibrator.getCalibrationValuesUpgraded();
        assertEquals(1, result.size());
        assertEquals(72, result.get(0));
    }

    @Test
    public void calibrator_creates_list_of_upgraded_calibration_values_from_multiple_inputs() {
        String input = "igjthreeierojgtwoioerjgi5ore\nrgfiveuh1reuigh7rgu\neriuhgeursevengh";
        Calibrator calibrator = new Calibrator(input);
        List<Integer> result = calibrator.getCalibrationValuesUpgraded();
        assertEquals(3, result.size());
        assertEquals(35, result.get(0));
        assertEquals(57, result.get(1));
        assertEquals(77, result.get(2));
    }

    @Test
    public void get_total_upgraded_calibration_value_for_one_input() {
        String input = "igjitwoerojgi2oerjgi5ore";
        Calibrator calibrator = new Calibrator(input);
        assertEquals(25, calibrator.getUpgradedCalibrationValue());
    }

    @Test
    public void get_total_upgradedcalibration_value_for_multiple_inputs() {
        String input = "igj9ierojgioerjgi7fiveore\nrgeightuh1reuigh7rgu\neriusevenhgeur9gh";
        Calibrator calibrator = new Calibrator(input);
        assertEquals(261, calibrator.getUpgradedCalibrationValue());
    }

    @Test
    public void get_total_upgradedcalibration_value_from_provided_test_input1() {
        String input = """
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet""";
        Calibrator calibrator = new Calibrator(input);
        assertEquals(142, calibrator.getUpgradedCalibrationValue());
    }

    @Test
    public void get_total_upgradedcalibration_value_from_provided_test_input2() {
        String input = """
                two1nine
                eightwothree
                abcone2threexyz
                xtwone3four
                4nineeightseven2
                zoneight234
                7pqrstsixteen""";
        Calibrator calibrator = new Calibrator(input);
        assertEquals(281, calibrator.getUpgradedCalibrationValue());
    }
}