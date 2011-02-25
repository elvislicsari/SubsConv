package com.subsconvertor.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

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

    public static BufferedReader getBufferedReaderFromByteArray(byte[] b) {
        ByteArrayInputStream bis = new ByteArrayInputStream(b);
        BufferedReader br = new BufferedReader(new InputStreamReader(bis));
        return br;
    }
}

