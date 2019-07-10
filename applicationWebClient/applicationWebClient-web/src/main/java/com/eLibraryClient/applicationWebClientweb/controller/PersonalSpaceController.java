package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUserBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class PersonalSpaceController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/PersonalSpace")
    public String personalSpace(@SessionAttribute(value = "userSession", required = false)LibraryUserBean userSession,
                                Model model) {


        model.addAttribute("log", userSession);
        return "PersonalSpace";
    }

}
