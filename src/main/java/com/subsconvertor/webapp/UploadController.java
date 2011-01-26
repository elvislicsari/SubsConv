package com.subsconvertor.webapp;

import com.subsconvertor.ConversionExec;
import com.subsconvertor.utils.FileUtils;
import com.subsconvertor.utils.Globals;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/index.html")
public class UploadController {

    Logger l = Logger.getLogger("UploadController");

    @RequestMapping(method = RequestMethod.GET)
    public String getUploadForm(Model model) {
        model.addAttribute(new UploadItem());
        info("se cheama asta ?");

        return "index.jsp";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(UploadItem sub, BindingResult result) {

        if (sub.getFramerateFrom() != 0 &&
                sub.getFramerateInto() != 0 &&
                !sub.getSubtitle().isEmpty()) {

            System.out.println("uploading 123");
            uploadFile(sub);
            System.out.println("end uploading");


        } else {
            info("sux mate");
        }

        return "redirect:index.jsp";
    }

    private void info(String message) {
        l.log(Level.INFO, message);
    }

    public void uploadFile(UploadItem sub) {
        try {

            System.out.println(ConversionExec.class.getClass().getResource(Globals.PATH_UPLOAD_ORIGINAL_SUBTITLES).getPath());

            System.out.println(UploadController.class.getClass().getResource(Globals.PATH_UPLOAD_ORIGINAL_SUBTITLES).getPath() +
                    sub.getSubtitle().getOriginalFilename());

            FileWriter fstreamWrite = new FileWriter(
                    UploadController.class.getClass().getResource(Globals.PATH_UPLOAD_ORIGINAL_SUBTITLES).getPath() +
                    sub.getSubtitle().getOriginalFilename());

            BufferedWriter out = new BufferedWriter(fstreamWrite);
            String fileContent = new String(sub.getSubtitle().getBytes());
            System.out.println("file length"+fileContent.length());
            out.write(fileContent);
            //Close the output stream
            out.close();
        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }
    }
}
