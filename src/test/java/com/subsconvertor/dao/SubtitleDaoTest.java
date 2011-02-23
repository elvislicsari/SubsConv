package com.subsconvertor.dao;

import com.google.api.translate.Language;
import com.subsconvertor.model.Subtitle;
import com.subsconvertor.model.SubtitleType;
import junit.framework.TestCase;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class SubtitleDaoTest extends TestCase {

    private SubtitleDao dao;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("dao-spring-context.xml");


        dao = (SubtitleDao) ctx.getBean("subtitleDao");
    }

    @org.junit.Test
    public void testSaveSubtitle() throws Exception {
        Subtitle subb = new Subtitle();
        subb.setFramerateFrom(25);
        subb.setFramerateInto(25);
        subb.setSubtitleName("test.srt");
        subb.setSubtitleContentType("srt");
        subb.setSubtitleConvertedContent(new byte[10]);
        subb.setSubtitleOriginalContent(new byte[10]);
        subb.setSubtitleType(SubtitleType.SubRip.toString());
        subb.setLanguage(Language.ROMANIAN.toString());

        System.out.println(dao);

        System.out.println(dao.saveSubtitle(subb));

    }
}
