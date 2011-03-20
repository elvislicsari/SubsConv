package com.subsconvertor.detector;

import com.subsconvertor.FilesHelperTest;
import com.subsconvertor.model.SubtitleType;
import com.subsconvertor.utils.FileUtils;
import com.subsconvertor.utils.Globals;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class SubsDetectorTest extends FilesHelperTest {
    @Test
    public void testDetectSubtitleType() throws Exception {



        SubsDetector sd = new SubsDetector();

        List<SubtitleDetectVoTest> arr = new ArrayList<SubtitleDetectVoTest>();
        arr.add(new SubtitleDetectVoTest("Crimes and Misdemeanors (Woody Allen 1989).srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("Crimes and Misdemeanors (1989).srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("TITANIC (1997) [Widescreen DVDRip].srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("Titanic (1997).srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("Titanic (EN).sub", SubtitleType.MicroDVD));
        arr.add(new SubtitleDetectVoTest("Titanic [1997] iNTERNAL - cfh.srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("Titanic [1997]- keltz.srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("Titanic HDRip264 1997.Eng.srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("Titanic.srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("Titanic.1997.720p.HD.Mepg-4.srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("Titanic.1997.DVDRip.XviD.AC3-FLAWL3SS.srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("Titanic.1997.HDTVRip.XviD.AC3.Subs-TmG.srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("Titanic.BRRip.AC3.DUAL.XviD[En].srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("Titanic[1997]DvDrip[Eng]-[By Deepu] Movie Size (1,527,934Kb).srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("Titanic[1997]DvDrip[Eng]-FANTASTiC.ENG.srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("TITANIC[1997]DVDrip-MMR4U.srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("Titanic_eng.srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("Titanic_Farsi.srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("TitanicCD1__.srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("Titanic [Bluray 720p and 1080p SRT].srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("test_utf8_chars.srt", SubtitleType.SubRip));
        arr.add(new SubtitleDetectVoTest("test_utf8_chars.sub", SubtitleType.MicroDVD));

        byte[] b;
        byte[] bTemp;
        for (int i = 0; i < arr.size(); i++) {

            String encoding = getEncoding(arr.get(i).getName());
            System.out.println(arr.get(i).getName());
            System.out.println(encoding);
            b = getByteArrayFromFile(arr.get(i).getName(), encoding);

            try {
                sd.detectSubtitleType(b);
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println(arr.get(i).getName());
                System.out.println(ex.getMessage());
            }
            assertEquals(sd.detectSubtitleType(b),
                    arr.get(i).getType());
//            System.out.println("ok");
        }

//
//        b = getByteArrayFromFile("Respiro.sub");
//        assertEquals(sd.detectSubtitleType(b),
//                SubtitleType.MicroDVD);
    }
}
