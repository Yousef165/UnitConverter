package com.application.converter.unit;

public class LengthUnit {

    public static double mileToYard(double mile) {
        return mile * 1760;
    }

    public static double mileToFoot(double mile) {
        return mile * 5280;
    }

    public static double mileToInch(double mile) {
        return mile * 63360;
    }

    public static double yardToMile(double yard) {
        return yard / 1760;
    }

    public static double yardToFoot(double yard) {
        return yard * 3;
    }

    public static double yardToInch(double yard) {
        return yard * 36;
    }

    public static double footToMile(double foot) {
        return foot / 5280;
    }

    public static double footToYard(double foot) {
        return foot / 3;
    }

    public static double footToInch(double foot) {
        return foot * 12;
    }

    public static double inchToMile(double inch) {
        return inch / 63360;
    }

    public static double inchToYard(double inch) {
        return inch / 36;
    }

    public static double inchToFoot(double inch) {
        return inch / 12;
    }

}
