package day1;

import day1.calibrator.Calibrator;

public class Solution {

    public Solution(String input) {
        System.out.println(new Calibrator(input).getCalibrationValue());
        System.out.println(new Calibrator(input).getUpgradedCalibrationValue());
    }

}
