package com.subsconvertor.utils;

/**
 *
 */
public class IntegerUtils {

    public static String appendZero(int i) {

        if (i < 10) {
            return "0" + i;
        } else {
            return "" + i;
        }
    }

    public static String appendZeroForMilli(int i) {

        if (i < 100) {
            if (i < 10) {
                return "00" + i;
            } else {
                return "0" + i;
            }
        } else {
            return "" + i;
        }
    }
}
