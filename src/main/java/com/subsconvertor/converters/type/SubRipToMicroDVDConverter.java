package com.subsconvertor.converters.type;

import com.subsconvertor.utils.Globals;
import com.subsconvertor.utils.IntegerUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
class SubRipToMicroDVDConverter implements SubtitleTypeConverter {

    public StringBuilder convert(StringBuilder sb, int targetFrameset) {
        StringBuilder sbNew = new StringBuilder();

        Scanner sc = new Scanner(sb.toString()).useDelimiter(Globals.newline);
        boolean nextLineIsContent = false;
        boolean alreadyAppendedLine = false;
        String subLine = "";
        while (sc.hasNext()) {
            subLine = sc.next();

            if (nextLineIsContent) {
                if (alreadyAppendedLine && !((subLine.equals(Globals.newline) || subLine.equals("")))) {
                    sbNew.append("|");
                }
                sbNew.append(subLine);
                alreadyAppendedLine = true;
            }

            Pattern pattern = Pattern.compile(Globals.SubRip_PATTERN_ENTIRE_TIME_LINE);
            Matcher matcher = pattern.matcher(subLine);
            if (matcher.find()) {
                sbNew.append("{");
                sbNew.append(Math.round(IntegerUtils.HMSMsSubRipStringToMilliSecs(matcher.group(1))
                        * targetFrameset) / 1000);
                sbNew.append("}{");
                sbNew.append(Math.round(IntegerUtils.HMSMsSubRipStringToMilliSecs(matcher.group(2))
                        * targetFrameset) / 1000);
                sbNew.append("}");

                nextLineIsContent = true;
            }

            if (subLine.equals(Globals.newline) || subLine.equals("")) {
                sbNew.append(Globals.newline);
                nextLineIsContent = false;
                alreadyAppendedLine = false;
            }
        }
        return sbNew;
    }
}
