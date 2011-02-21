package com.subsconvertor.detector;

import com.subsconvertor.FilesHelperTest;
import com.subsconvertor.model.SubtitleType;
import com.subsconvertor.utils.Globals;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class SubsDetectorTest extends FilesHelperTest {
    @Test
    public void testDetectSubtitleType() throws Exception {

        SubsDetector sd = new SubsDetector();

        byte[] b = getByteArrayFromFile("SinNombre.srt");
        assertEquals(sd.detectSubtitleType(b),
                SubtitleType.SubRip);

        b = getByteArrayFromFile("Respiro.sub");
        assertEquals(sd.detectSubtitleType(b),
                SubtitleType.MicroDVD);
    }
}
