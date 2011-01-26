package com.subsconvertor.converters;

import com.subsconvertor.exception.SystemException;
import com.subsconvertor.utils.Globals;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SubConverter implements Converter {

    public StringBuilder createNewConvertedSubtitle(File sub, BigDecimal ratio) {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fstream = new FileInputStream(sub);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
//            int counter = 1;
            while ((strLine = br.readLine()) != null) {
                Pattern pattern = Pattern.compile(Globals.SUB_PATTERN_FIRST_LINE);
                Matcher matcher = pattern.matcher(strLine);
//                String newString = "";
//                System.out.println(strLine);
                while (matcher.find()) {
//                    System.out.println(matcher.group());
                    String millisecsStr = matcher.group().replace("{", "").replace("}", "");
                    long millisecs = Long.parseLong(millisecsStr);
//                    System.out.println(millisecs);
                    BigDecimal newMilliSecs = ratio.multiply(new BigDecimal(millisecs));
//                      System.out.println(newMilliSecs);
                    newMilliSecs = newMilliSecs.setScale(0, RoundingMode.HALF_UP);
                    newMilliSecs = newMilliSecs.round(MathContext.DECIMAL32);
//                    System.out.println(newMilliSecs);
//                    System.out.println("xxxxxxxxxx");
                    strLine = strLine.replace(millisecsStr, ""+newMilliSecs);

//                    int hour = Integer.parseInt(matcher.group().substring(0, 2));
//                    int minute = Integer.parseInt(matcher.group().substring(3, 5));
//                    int seconds = Integer.parseInt(matcher.group().substring(6, 8));
//                    int milliSec = Integer.parseInt(matcher.group().substring(9, 12));
//
//
//                    List<Integer> lstInt = getNewTime(hour, minute, seconds, milliSec);
//                    DateTime newTmstp = new DateTime(2010, 12, 1, lstInt.get(0), lstInt.get(1), lstInt.get(2), lstInt.get(3));
//
//                    String newStr = IntegerUtils.appendZero(newTmstp.getHourOfDay()) + ":" +
//                            IntegerUtils.appendZero(newTmstp.getMinuteOfHour()) + ":" +
//                            IntegerUtils.appendZero(newTmstp.getSecondOfMinute()) + "," +
//                            IntegerUtils.appendZeroForMilli(newTmstp.getMillisOfSecond());
//
//                    newString += newStr + " --> ";
                }

//                if (!newString.equals("")) {
//                    newString = newString.substring(0, 30);
//                } else {
//                    newString = strLine;
//                }
//                newString += Globals.newline;


                sb.append(strLine + Globals.newline);
//                System.out.println(sb);

//                if (counter > 10) {
//                    System.exit(0);
//                }
//                counter++;
            }

            in.close();
        } catch (Exception e) {
            throw new SystemException(e.getMessage());
        }
//        System.out.println(sb);
//        System.exit(0);
        return sb;
    }
}
