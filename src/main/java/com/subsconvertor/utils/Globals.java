package com.subsconvertor.utils;

/**
 *
 */
public interface Globals {

    public static final String newline = System.getProperty("line.separator");

    //SubRip FILE patterns
    public static final String SubRip_PATTERN_FIRST_LINE = "^\\d+$";
    public static final String SubRip_PATTERN_TIME_LINE = "(\\d{2}):(\\d{2}):(\\d{2})\\,(\\d{3})";
    public static final String SubRip_PATTERN_ENTIRE_TIME_LINE = "(\\d{2}:\\d{2}:\\d{2}\\,\\d{3}) --> (\\d{2}:\\d{2}:\\d{2}\\,\\d{3})";

    //sub files patterns
    public static final String MicroDVD_PATTERN_FIRST_LINE = "\\{\\d+\\}";
    public static final String MicroDVD_PATTERN_SECOND_LINE = "\\{\\d+\\}";
    public static final String MicroDVD_PATTERN_ENTIRE_LINE = "\\{(\\d+)\\}\\{(\\d+)\\}(.*)";

    public static final String linesSeparator = "|";
    public static final int googleTranslatorCharsLimit = 3000;
}
