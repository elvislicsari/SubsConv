package com.subsconvertor.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

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


    public static String milliSecsToHMSMs(long millisecs) {
        DateTime date = new DateTime(millisecs, DateTimeZone.UTC);

        return appendZero(date.getHourOfDay())+":"
                +appendZero(date.getMinuteOfHour())+":"
                +appendZero(date.getSecondOfMinute())+","
                +appendZeroForMilli(date.getMillisOfSecond());
    }
}
