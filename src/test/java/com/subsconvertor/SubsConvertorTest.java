package com.subsconvertor;

import java.io.File;
import java.math.BigDecimal;

/**
 *
 */
public class SubsConvertorTest {
    @org.junit.Test
    public void testConversion() throws Exception {

        ConversionExec conv = new ConversionExec();
        conv.setFromFramerate(new BigDecimal(23.976));
        conv.setToFramerate(new BigDecimal(25));
        conv.convert("Respiro.sub");
    }
}
