package com.subsconvertor.converters;

import java.io.File;
import java.math.BigDecimal;

/**
 *
 */
public interface Converter {
    public StringBuilder createNewConvertedSubtitle(byte[] subtitle, BigDecimal ratio);
}
