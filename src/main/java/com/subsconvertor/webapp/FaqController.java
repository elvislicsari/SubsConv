package com.subsconvertor.webapp;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.View;

@Controller
@RequestMapping(value = "/faq")
public class FaqController {

    @RequestMapping(method = RequestMethod.GET)
    public String getPage() {

        return "faq";
    }

}
