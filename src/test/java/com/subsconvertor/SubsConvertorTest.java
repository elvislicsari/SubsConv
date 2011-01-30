package com.subsconvertor;

import com.subsconvertor.detector.SubtitleType;

import java.math.BigDecimal;

/**
 *
 */
public class SubsConvertorTest extends FilesHelperTest {
    @org.junit.Test
    public void testConversion() throws Exception {

        ConversionExec conv = new ConversionExec();
        conv.setFromFramerate(new BigDecimal(29.97));
        conv.setToFramerate(new BigDecimal(29.97));
//        byte[] b = getByteArrayFromFile("Respiro.sub");
//        StringBuilder sb = conv.convert(b);
//        saveNewConvertedFile(sb, "Respiro_converted.sub");
//
//        byte[] b = getByteArrayFromFile("SinNombre.srt");
//        StringBuilder sb = conv.convert(b);
//        saveNewConvertedFile(sb, "subsynched.srt");


//        conv.setSubtitleType(SubtitleType.SubRip);
//        byte[] b = getByteArrayFromFile("Black.Swan.2010.720p.WEBSCR.XviD.AC3-TiMPE.sub");
//        StringBuilder sb = conv.convert(b);
//        saveNewConvertedFile(sb, "subsynch_converted.srt");


//        conv.setSubtitleType(SubtitleType.MicroDVD);
//        byte[] b = getByteArrayFromFile("Black.Swan.2010.720p.WEBSCR.XviD.AC3-TiMPE.srt");
//        StringBuilder sb = conv.convert(b);
//        saveNewConvertedFile(sb, "Black.Swan.2010.720p.WEBSCR.XviD.AC3-TiMPE.sub");


    }
}
