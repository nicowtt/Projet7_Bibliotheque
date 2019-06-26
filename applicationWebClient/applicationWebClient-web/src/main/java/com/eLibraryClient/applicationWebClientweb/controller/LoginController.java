package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientbusiness.contract.LibraryUserManager;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LoginController {

    @Autowired
    private LibraryUserManager libraryUserManager;

    /**
     * For user login
     *
     * @param userSession -> user on session
     * @param request
     * @param status
     * @param model -> model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@ModelAttribute("userSession")LibraryUserBean userSession, WebRequest request, SessionStatus status, Model model) {

        LibraryUserBean userOnBdd = new LibraryUserBean();

        //check if user exist on BDD
        userOnBdd = libraryUserManager.getLibraryUser(userSession.getUseremail());
        //todo si le model attribute correspond a quelqu'un de la liste c'est ok

        return "home";
    }




}
