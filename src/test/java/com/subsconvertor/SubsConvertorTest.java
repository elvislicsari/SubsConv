package com.subsconvertor;

import com.subsconvertor.detector.SubtitleType;

import java.io.File;
import java.math.BigDecimal;

/**
 *
 */
public class SubsConvertorTest extends FilesHelperTest {
    @org.junit.Test
    public void testConversion() throws Exception {

        ConversionExec conv = new ConversionExec();
        conv.setFromFramerate(new BigDecimal(23.976));
        conv.setToFramerate(new BigDecimal(25));
//        byte[] b = getByteArrayFromFile("Respiro.sub");
//        StringBuilder sb = conv.convert(b);
//        saveNewConvertedFile(sb, "Respiro_converted.sub");
//
//        b = getByteArrayFromFile("SinNombre.srt");
//        sb = conv.convert(b);
//        saveNewConvertedFile(sb, "SinNombre_converted.srt");


        conv.setSubtitleType(SubtitleType.SRT);
        byte[] b = getByteArrayFromFile("Respiro.sub");
        StringBuilder sb = conv.convert(b);
        sb = conv.convert(b);
        saveNewConvertedFile(sb, "Respiro_converted.srt");


    }
}
