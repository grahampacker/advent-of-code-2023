package day1.calibrator;

import java.util.*;

public class CalibrationInput {

    private static final List<String> numberStrings = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
    private static final List<String> upgradedNumberStrings = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    private static final Map<String, String> numberWordToNumericMap = Map.of(
            "one", "1",
            "two", "2",
            "three", "3",
            "four", "4",
            "five", "5",
            "six", "6",
            "seven", "7",
            "eight", "8",
            "nine", "9"
    );

    private String inputValue;

    public CalibrationInput(String input) {
        if (null == input || input.isEmpty()) {
            throw new RuntimeException("Could not process input.");
        }
        this.inputValue = input;
    }

    public String getInputValue() {
        return this.inputValue;
    }

    public String getFirstNumberInInput() {
        return getFirstNumberInStringList(Arrays.asList(inputValue.split("")));
    }

    public String getFirstNumberInInputUpgraded() {
        String lowestNumberString = null;
        int lowestNumberStringIndex = Integer.MAX_VALUE;
        for (String numberString : upgradedNumberStrings) {
            int indexOfNumber = inputValue.indexOf(numberString);
            if (indexOfNumber != -1 && indexOfNumber < lowestNumberStringIndex) {
                lowestNumberStringIndex = indexOfNumber;
                lowestNumberString = numberString;
            }
        }
        if (lowestNumberString == null) {
            throw new RuntimeException("No number value found");
        } else {
            if(numberStrings.contains(lowestNumberString)) {
                return lowestNumberString;
            } else {
                return numberWordToNumericMap.get(lowestNumberString);
            }
        }
    }

    public String getLastNumberInInputUpgraded() {
        String highestNumberString = null;
        int highestNumberStringIndex = Integer.MIN_VALUE;
        for (String numberString : upgradedNumberStrings) {
            int indexOfNumber = inputValue.lastIndexOf(numberString);
            if (indexOfNumber != -1 && indexOfNumber > highestNumberStringIndex) {
                highestNumberStringIndex = indexOfNumber;
                highestNumberString = numberString;
            }
        }
        if (highestNumberString == null) {
            throw new RuntimeException("No number value found");
        } else {
            if(numberStrings.contains(highestNumberString)) {
                return highestNumberString;
            } else {
                return numberWordToNumericMap.get(highestNumberString);
            }
        }
    }

    public String getLastNumberInInput() {
        List<String> splitInput = Arrays.asList(inputValue.split(""));
        Collections.reverse(splitInput);
        return getFirstNumberInStringList(splitInput);
    }

    private String getFirstNumberInStringList(List<String> input) {
        for (String character : input) {
            if (numberStrings.contains(character)) {
                return character;
            }
        }
        throw new RuntimeException("No number value found");
    }
}