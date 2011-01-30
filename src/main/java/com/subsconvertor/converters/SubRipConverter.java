package com.subsconvertor.converters;

import com.subsconvertor.exception.SystemException;
import com.subsconvertor.utils.FileUtils;
import com.subsconvertor.utils.IntegerUtils;
import com.subsconvertor.utils.Globals;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SubRipConverter implements Converter {

    private BigDecimal ratio;

    public StringBuilder createNewConvertedSubtitle(byte[] b, BigDecimal ratio) {
        this.ratio = ratio;
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = FileUtils.getBufferedReaderFromByteArray(b);

            String strLine;

            while ((strLine = br.readLine()) != null) {
                Pattern pattern = Pattern.compile(Globals.SubRip_PATTERN_TIME_LINE);
                Matcher matcher = pattern.matcher(strLine);
                String newString = "";
                while (matcher.find()) {

                    int hour = Integer.parseInt(matcher.group(1));
                    int minute = Integer.parseInt(matcher.group(2));
                    int seconds = Integer.parseInt(matcher.group(3));
                    int milliSec = Integer.parseInt(matcher.group(4));

                    long newTime = getNewTime(hour, minute, seconds, milliSec);

                    DateTime newTmstp = new DateTime(newTime, DateTimeZone.UTC);

                    String newStr = IntegerUtils.appendZero(newTmstp.getHourOfDay()) + ":" +
                            IntegerUtils.appendZero(newTmstp.getMinuteOfHour()) + ":" +
                            IntegerUtils.appendZero(newTmstp.getSecondOfMinute()) + "," +
                            IntegerUtils.appendZeroForMilli(newTmstp.getMillisOfSecond());

                    newString += newStr + " --> ";
                }

                if (!newString.equals("")) {
                    newString = newString.substring(0, 30);
                } else {
                    newString = strLine;
                }
                newString += Globals.newline;


                sb.append(newString);

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException(e.getMessage());
        }
        return sb;
    }

    private long getNewTime(int hour, int minute, int seconds, int milliSec) {
        double d = (hour*3600*1000+minute*60*1000+seconds*1000+milliSec)*ratio.doubleValue();
        return (long)d;
    }
}
