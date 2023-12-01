package day1.calibrator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calibrator {

    List<CalibrationInput> calibrationInputs;

    public Calibrator(String input) {
        if(null == input || input.isEmpty()) {
            throw new RuntimeException("Calibrator input was invalid.");
        }

        calibrationInputs = new ArrayList<>();

        Arrays.stream(input.split("\n")).forEach(line -> calibrationInputs.add(new CalibrationInput(line)));
    }

    protected List<CalibrationInput> getCalibratorInput() {
        return calibrationInputs;
    }

    public int getCalibrationValue() {
        return getCalibrationValues().stream().mapToInt(i -> i).sum();
    }

    public int getUpgradedCalibrationValue() {
        return getCalibrationValuesUpgraded().stream().mapToInt(i -> i).sum();
    }

    protected List<Integer> getCalibrationValues() {
        return calibrationInputs.stream()
                .map(this::concatFirstAndLastNumbersInCalibrationInput)
                .map(Integer::parseInt)
                .toList();
    }

    protected List<Integer> getCalibrationValuesUpgraded() {
        return calibrationInputs.stream()
                .map(this::concatFirstAndLastNumbersInCalibrationInputUpgraded)
                .map(Integer::parseInt)
                .toList();
    }

    private String concatFirstAndLastNumbersInCalibrationInput(CalibrationInput calibrationInput) {
        return calibrationInput.getFirstNumberInInput() + calibrationInput.getLastNumberInInput();
    }

    private String concatFirstAndLastNumbersInCalibrationInputUpgraded(CalibrationInput calibrationInput) {
        return calibrationInput.getFirstNumberInInputUpgraded() + calibrationInput.getLastNumberInInputUpgraded();
    }

}
