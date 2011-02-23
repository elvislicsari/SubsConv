package com.subsconvertor.detector;

import com.subsconvertor.exception.SubtitleTypeException;
import com.subsconvertor.exception.SystemException;
import com.subsconvertor.model.SubtitleType;
import com.subsconvertor.utils.Globals;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Detects the subtitle type based on the content of the subtitle file
 */
public class SubsDetector {

    public SubtitleType detectSubtitleType(byte[] b) {

        ByteArrayInputStream bis = new ByteArrayInputStream(b);
        BufferedReader br = new BufferedReader(new InputStreamReader(bis));

        if (checkSrtFile(br)) {
            return SubtitleType.SubRip;
        } else if (checkSubFile(br)) {
            return SubtitleType.MicroDVD;
        } else {
            throw new SubtitleTypeException("Subtitle type not recognized!");
        }
    }

    protected boolean checkSrtFile(BufferedReader br) {
        try {
            String strLine;
            int counter = 1;
            boolean srtFirstLine = false;
            boolean srtSecondLine = false;
            while ((strLine = br.readLine()) != null) {
                if (counter == 1) {
                    Pattern pattern = Pattern.compile(Globals.SubRip_PATTERN_FIRST_LINE);
                    Matcher matcher = pattern.matcher(strLine);
                    while (matcher.find()) {
                        if (matcher.group() != null) {
                            srtFirstLine = true;
                        }
                    }
                }
                if (counter == 2 && srtFirstLine == true) {
                    Pattern pattern = Pattern.compile(Globals.SubRip_PATTERN_TIME_LINE);
                    Matcher matcher = pattern.matcher(strLine);
                    if (matcher.find()) {
                        srtSecondLine = true;
                    }
                }
                if (counter > 2) {
                    break;
                }
                counter++;
            }
            if (srtFirstLine == true && srtSecondLine == true) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new SystemException(ex.getMessage());
        }
        return false;
    }

    protected boolean checkSubFile(BufferedReader br) {
        try {
            String strLine;
            int counter = 1;
            boolean subFirstLine = false;
            boolean subSecondLine = false;
            while ((strLine = br.readLine()) != null) {
                if (counter == 1) {
                    Pattern pattern = Pattern.compile(Globals.MicroDVD_PATTERN_FIRST_LINE);
                    Matcher matcher = pattern.matcher(strLine);
                    while (matcher.find()) {
                        if (matcher.group() != null) {
                            subFirstLine = true;
                        }
                    }
                }
                if (counter == 2 && subFirstLine == true) {
                    Pattern pattern = Pattern.compile(Globals.MicroDVD_PATTERN_SECOND_LINE);
                    Matcher matcher = pattern.matcher(strLine);
                    if (matcher.find()) {
                        subSecondLine = true;
                    }
                }
                if (counter > 2) {
                    break;
                }
                counter++;
            }
            if (subFirstLine == true && subSecondLine == true) {
                return true;
            }
        } catch (Exception ex) {
            throw new SystemException(ex.getMessage());
        }
        return false;
    }
}
