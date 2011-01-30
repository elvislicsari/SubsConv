package com.subsconvertor.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    public static String milliSecsToHMSMsSubRipString(long millisecs) {
        DateTime date = new DateTime(millisecs, DateTimeZone.UTC);

        return appendZero(date.getHourOfDay())+":"
                +appendZero(date.getMinuteOfHour())+":"
                +appendZero(date.getSecondOfMinute())+","
                +appendZeroForMilli(date.getMillisOfSecond());
    }

    public static long HMSMsSubRipStringToMilliSecs(String timeStr) {
        Pattern pattern = Pattern.compile(Globals.SubRip_PATTERN_TIME_LINE);
        Matcher matcher = pattern.matcher(timeStr);
        matcher.find();

        return Long.parseLong(matcher.group(1))*3600*1000 +
                Long.parseLong(matcher.group(2))*60*1000 +
                Long.parseLong(matcher.group(3))*1000 +
                Long.parseLong(matcher.group(4));
    }
}
