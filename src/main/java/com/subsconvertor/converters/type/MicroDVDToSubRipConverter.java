package com.subsconvertor.converters.type;

import com.subsconvertor.utils.Globals;
import com.subsconvertor.utils.IntegerUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
class MicroDVDToSubRipConverter implements SubtitleTypeConverter {

    public StringBuilder convert(StringBuilder sb, int targetFrameset) {
        StringBuilder sbNew = new StringBuilder();

        Scanner sc = new Scanner(sb.toString()).useDelimiter(Globals.newline);
        int lineCounter = 1;
        String subLine = "";
        while (sc.hasNext()) {
            subLine = sc.next();
            sbNew.append(lineCounter);
            sbNew.append(Globals.newline);
            Pattern pattern = Pattern.compile(Globals.MicroDVD_PATTERN_ENTIRE_LINE);
            Matcher matcher = pattern.matcher(subLine);
            matcher.find();
            sbNew.append(IntegerUtils.milliSecsToHMSMsSubRipString(Long.parseLong(matcher.group(1)) * 1000 / targetFrameset)
                    + " --> " +
                    IntegerUtils.milliSecsToHMSMsSubRipString(Long.parseLong(matcher.group(2)) * 1000 / targetFrameset));
            sbNew.append(Globals.newline);
            sbNew.append(matcher.group(3));
            sbNew.append(Globals.newline);
            sbNew.append(Globals.newline);
            lineCounter++;
        }

        return sbNew;
    }
}
