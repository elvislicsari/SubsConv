package com.subsconvertor.webapp;

import com.subsconvertor.ConversionExec;
import com.subsconvertor.dao.PMF;
import com.subsconvertor.dao.Subtitle;
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

            System.out.println("uploading");
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
        System.out.println("upload");
        PMF.get().getPersistenceManager().makePersistent(new Subtitle());
        System.out.println("dupa upload");
    }
}
