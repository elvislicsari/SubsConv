package com.subsconvertor.utils;

/**
 *
 */
public interface Globals {

    public static final String newline = System.getProperty("line.separator");

    //SRT FILE patterns
    public static final String SRT_PATTERN_FIRST_LINE = "\\d+";
    public static final String SRT_PATTERN_TIME_LINE = "\\d{2}:\\d{2}:\\d{2}\\,\\d{3}";

    //sub files patterns
    public static final String SUB_PATTERN_FIRST_LINE = "\\{\\d+\\}";
    public static final String SUB_PATTERN_SECOND_LINE = "\\{\\d+\\}";

    //sub file paths
    public static final String PATH_UPLOAD_ORIGINAL_SUBTITLES = "/files/original/";
    public static final String PATH_CONVERTED_SUBTITLES = "/files/converted/";

}
