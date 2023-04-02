package com.application.converter.unit;

public class WeightUnit {

    public static double poundToOunce(double pound) {
        return pound * 16;
    }

    public static double poundToGram(double pound) {
        return pound * 453.592;
    }

    public static double poundToKilogram(double pound) {
        return pound * 0.453592;
    }

    public static double ounceToPound(double ounce) {
        return ounce / 16;
    }

    public static double ounceToGram(double ounce) {
        return ounce * 28.3495;
    }

    public static double ounceToKilogram(double ounce) {
        return ounce * 0.0283495;
    }

    public static double gramToPound(double gram) {
        return gram / 453.592;
    }

    public static double gramToOunce(double gram) {
        return gram / 28.3495;
    }

    public static double gramToKilogram(double gram) {
        return gram * 0.001;
    }

    public static double kilogramToPound(double kilogram) {
        return kilogram / 0.453592;
    }

    public static double kilogramToOunce(double kilogram) {
        return kilogram / 0.0283495;
    }

    public static double kilogramToGram(double kilogram) {
        return kilogram / 0.001;
    }
}
