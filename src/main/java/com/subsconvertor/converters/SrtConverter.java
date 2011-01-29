package com.subsconvertor.converters;

import com.subsconvertor.exception.SystemException;
import com.subsconvertor.utils.FileUtils;
import com.subsconvertor.utils.IntegerUtils;
import com.subsconvertor.utils.Globals;
import org.joda.time.DateTime;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SrtConverter implements Converter {

    private BigDecimal ratio;

    public StringBuilder createNewConvertedSubtitle(byte[] b, BigDecimal ratio) {
        this.ratio = ratio;
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = FileUtils.getBufferedReaderFromByteArray(b);

            String strLine;

            while ((strLine = br.readLine()) != null) {
                Pattern pattern = Pattern.compile(Globals.SRT_PATTERN_TIME_LINE);
                Matcher matcher = pattern.matcher(strLine);
                String newString = "";
                while (matcher.find()) {
                    int hour = Integer.parseInt(matcher.group().substring(0, 2));
                    int minute = Integer.parseInt(matcher.group().substring(3, 5));
                    int seconds = Integer.parseInt(matcher.group().substring(6, 8));
                    int milliSec = Integer.parseInt(matcher.group().substring(9, 12));


                    List<Integer> lstInt = getNewTime(hour, minute, seconds, milliSec);
                    DateTime newTmstp = new DateTime(2010, 12, 1, lstInt.get(0), lstInt.get(1), lstInt.get(2), lstInt.get(3));

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
            throw new SystemException(e.getMessage());
        }
        return sb;
    }

    private List<Integer> getNewTime(int hour, int minute, int seconds, int milliSec) {
        List<Integer> lstNew = new ArrayList<Integer>();
        BigDecimal bd = new BigDecimal(0);
        bd = bd.add(new BigDecimal(hour * 3600 * 1000));
        bd = bd.add(new BigDecimal(minute * 60 * 1000));
        bd = bd.add(new BigDecimal(seconds * 1000));
        bd = bd.add(new BigDecimal(milliSec));
        bd = bd.multiply(ratio);

        BigDecimal newHour = bd.divide(new BigDecimal(3600 * 1000), 4);
        int newHourInt = newHour.intValue();
        BigDecimal newMinute = bd.subtract(new BigDecimal(newHourInt * 3600 * 1000))
                .divide(new BigDecimal(60 * 1000), 4);
        int newMinuteint = newMinute.intValue();

        BigDecimal newSeconds = bd.subtract(new BigDecimal(newHourInt * 3600 * 1000))
                .subtract(new BigDecimal(newMinuteint * 60 * 1000))
                .divide(new BigDecimal(1000), 4);
        int newSecondsInt = newSeconds.intValue();

        BigDecimal newMillisec = bd.subtract(new BigDecimal(newHourInt * 3600 * 1000))
                .subtract(new BigDecimal(newMinuteint * 60 * 1000))
                .subtract(new BigDecimal(newSecondsInt * 1000));


        lstNew.add(0, newHourInt);
        lstNew.add(1, newMinuteint);
        lstNew.add(2, newSecondsInt);
        lstNew.add(3, newMillisec.intValue());

        return lstNew;
    }
}
