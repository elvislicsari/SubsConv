package com.subsconvertor.utils;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;
import com.subsconvertor.exception.SystemException;

import java.io.*;
import java.util.Arrays;

/**
 *
 */
public class FileUtils {

    private FileUtils() {
    }

    public static String getFileName(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    public static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static BufferedReader getBufferedReaderFromByteArray(byte[] b, String encoding) {
        ByteArrayInputStream bis = new ByteArrayInputStream(b);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(bis, encoding));
        } catch (UnsupportedEncodingException e) {
            throw new SystemException(e.getMessage());
        }
        return br;
    }

    public static String detectEncoding(byte[] b) {
        CharsetDetector detector = new CharsetDetector();
        detector.setText(b);
        CharsetMatch match = detector.detect();
        String encoding = match.getName();
        if (encoding.contains("UTF-16")) {
            encoding = "UTF-16";
        }
        return encoding;
    }

    public static String detectEncoding(InputStream in) {
        CharsetDetector detector = new CharsetDetector();
        try {
            detector.setText(in);
        } catch (IOException e) {
            throw new SystemException(e.getMessage());
        }
        CharsetMatch match = detector.detect();
        String encoding = match.getName();
        if (encoding.contains("UTF-16")) {
            encoding = "UTF-16";
        }
        return encoding;
    }

    public static byte[] getByteArrayWithoutBOM(InputStream in) throws IOException {
        UnicodeBOMInputStream uin = new UnicodeBOMInputStream(in);
        uin.skipBOM();
        byte[] b = new byte[uin.available()];
        uin.read(b);
        return b;
    }
}

