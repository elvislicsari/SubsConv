package com.subsconvertor.webapp;

import com.google.api.translate.Language;
import com.subsconvertor.ConversionExec;
import com.subsconvertor.dao.SubtitleDao;
import com.subsconvertor.detector.SubsDetector;
import com.subsconvertor.exception.SubtitleTypeException;
import com.subsconvertor.model.Subtitle;
import com.subsconvertor.model.SubtitleType;
import com.subsconvertor.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping(value = {"/", "/synchronize", " * "})
public class SubSynchController {

    @Autowired
    private SubtitleDao subtitleDao;
    private Language[] languages = Language.values();

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("synchronize");
//        Arrays.toString(languages);
        model.addObject("languages", languages);
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView saveAndConvertSub(@RequestParam("framerateFrom") float framerateFrom,
                                          @RequestParam("framerateInto") float framerateInto,
                                          @RequestParam("subtitle") CommonsMultipartFile sub,
                                          @RequestParam("subtitleType") String subtitleTypeChosen,
                                          @RequestParam("languageFrom") String languageFrom,
                                          @RequestParam("languageInto") String languageInto,
                                          HttpServletResponse response) {



        List<String> messages = new ArrayList<String>();
//        System.out.println(framerateFrom);
//        System.out.println(framerateInto);
//        System.out.println(sub);
//        System.out.println(subtitleTypeChosen);
//        System.out.println(languageFrom);
//        System.out.println(languageInto);

        if (sub != null && !sub.isEmpty()) {
            SubsDetector detect = new SubsDetector();
            try {
                SubtitleType typeDetected = detect.detectSubtitleType(sub.getBytes());
                String subtitleExtension = typeDetected.getExtension();

                if ((framerateFrom != 0.0 && framerateInto != 0.0 &&
                        (framerateFrom != framerateInto ||
                                (framerateFrom == framerateInto && (!subtitleTypeChosen.equals("none") && !subtitleTypeChosen.equals(typeDetected.toString()))))) ||
                        (!languageFrom.equals("none") && !languageInto.equals("none") && !languageFrom.equals(languageInto))) {

                    Subtitle subb = new Subtitle();
                    subb.setSubtitleName(sub.getOriginalFilename());
                    subb.setSubtitleContentType(sub.getContentType());
                    subb.setSubtitleOriginalContent(sub.getBytes());

                    ConversionExec conv = new ConversionExec(detect);

                    if (framerateFrom != 0.0 && framerateInto != 0.0 &&
                            (framerateFrom != framerateInto ||
                                    (framerateFrom == framerateInto && (!subtitleTypeChosen.equals("none") && !subtitleTypeChosen.equals(typeDetected))))) {
                        subb.setFramerateFrom(framerateFrom);
                        subb.setFramerateInto(framerateInto);
                        conv.setFromFramerate(new BigDecimal(framerateFrom));
                        conv.setToFramerate(new BigDecimal(framerateInto));
                        if (!subtitleTypeChosen.equals("none") && !subtitleTypeChosen.equals(typeDetected)) {
                            subb.setSubtitleType(subtitleTypeChosen);
                            conv.setSubtitleType(SubtitleType.valueOf(subtitleTypeChosen));
                            subtitleExtension = SubtitleType.valueOf(subtitleTypeChosen).getExtension();
                        } else {
                            subb.setSubtitleType(typeDetected.toString());
                        }
                    } else {
                        subb.setFramerateFrom(0);
                        subb.setFramerateInto(0);
                        conv.setFromFramerate(new BigDecimal(0));
                        conv.setToFramerate(new BigDecimal(0));
                        subb.setSubtitleType(typeDetected.toString());
                    }

                    if (!languageFrom.equals("none") && !languageInto.equals("none") && !languageFrom.equals(languageInto)) {
                        subb.setLanguage(languageInto);
                        conv.setLanguageFrom(Language.valueOf(languageFrom));
                        conv.setLanguageInto(Language.valueOf(languageInto));
                    }

                    StringBuilder convertedSub = null;
                    try {
                        convertedSub = conv.convert(sub.getBytes());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    subb.setSubtitleConvertedContent(convertedSub.toString().getBytes());

                    subtitleDao.saveSubtitle(subb);

                    try {
                        response.setHeader("Content-Disposition", "inline;filename=\""
                                + FileUtils.getFileName(sub.getOriginalFilename()) + "_subsynched"
                                + subtitleExtension
                                + "\"");
                        OutputStream out = response.getOutputStream();
                        response.setContentType(sub.getContentType());
                        out.write(convertedSub.toString().getBytes());
                        out.flush();
                        out.close();
                        return null;

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    messages.add("Choose to change the framerate, subtitle type or subtitle language!");
                }
            } catch (SubtitleTypeException ex) {
                messages.add(ex.getMessage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            messages.add("Please choose a subtitle!");
        }

        ModelAndView model = new ModelAndView();
        model.setViewName("synchronize");
        if (messages.size() > 0) {
            model.addObject("messages", messages);

        }
        model.addObject("languages", languages);

        return model;
    }

//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleException(Exception ex, HttpServletRequest request) {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("error");
//        model.addObject("errorMessage", ex.getMessage());
//        return model;
//    }

//    private void info(String message) {
//        logger.log(Level.INFO, message);
//    }


//    public void setSubtitleDao(SubtitleDao dao) {
//        subtitleDao = dao;
//    }
}
