package com.subsconvertor.utils;

import java.io.File;

/**
 *
 */
public class FileUtils {

    public static String getFileName(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    public static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
}

