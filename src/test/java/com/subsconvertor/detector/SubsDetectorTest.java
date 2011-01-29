package com.subsconvertor.detector;

import com.subsconvertor.FilesHelperTest;
import com.subsconvertor.utils.Globals;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 *
 */
public class SubsDetectorTest extends FilesHelperTest {
    @Test
    public void testDetectSubtitleType() throws Exception {
        SubsDetector sd = new SubsDetector();

        byte[] b  = getByteArrayFromFile("SinNombre.srt");
        assertEquals(sd.detectSubtitleType(b),
                SubtitleType.SRT);

        b = getByteArrayFromFile("Respiro.sub");
        assertEquals(sd.detectSubtitleType(b),
                SubtitleType.SUB);
    }
}
