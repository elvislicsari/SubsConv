package com.subsconvertor.detector;

import com.subsconvertor.utils.Globals;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;

/**
 *
 */
public class SubsDetectorTest extends TestCase {
    @Test
    public void testDetectSubtitleType() throws Exception {
        SubsDetector sd = new SubsDetector();

//        assertEquals(sd.detectSubtitleType(new File("files\\original\\SinNombre.srt")),
//                SubtitleType.SRT);
//        assertEquals(sd.detectSubtitleType(new File("files\\original\\Respiro.sub")),
//                SubtitleType.SUB);

        assertEquals(sd.detectSubtitleType(new File(
                SubsDetectorTest.class.getResource(Globals.PATH_UPLOAD_ORIGINAL_SUBTITLES).getPath()
                        +"SinNombre.srt")),
                SubtitleType.SRT);
        assertEquals(sd.detectSubtitleType(new File(
                SubsDetectorTest.class.getResource(Globals.PATH_UPLOAD_ORIGINAL_SUBTITLES).getPath()+
                "Respiro.sub")),
                SubtitleType.SUB);
    }
}
