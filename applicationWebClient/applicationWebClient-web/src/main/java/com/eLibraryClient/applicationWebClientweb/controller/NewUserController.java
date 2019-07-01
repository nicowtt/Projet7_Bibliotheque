package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientbusiness.contract.LibraryUserManager;
import com.eLibraryClient.applicationWebClientbusiness.contract.PasswordEncoder;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUserBean;
import com.eLibraryClient.applicationWebClientproxies.proxies.MicroserviceBDDProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Controller
public class NewUserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LibraryUserManager libraryUserManager;

    /**
     * For display newUser page
     * @param model -> model
     * @return
     */
    @GetMapping(value = "/newUser")
    public String newUser(Model model) {

        //model for display new user form
        model.addAttribute("newUser", new LibraryUserBean());

        return "/newUser";
    }

    /**
     * For write on microserviceDD
     * @param LibraryNewUser -> bean to validate
     * @param bindingResult -> list of error
     * @param model -> models
     * @return
     */
    @PostMapping(value = "/newUserPost")
    public String newUserPost(@Valid @ModelAttribute("newUser") LibraryUserBean LibraryNewUser, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("newUser", LibraryNewUser);
            logger.info("*********");
            logger.info("erreur lors du remplissage formulaire enregistrement nouvel utilisateur");
            logger.debug("debug");

            return "/newUser";
        } else {
            // hashing new password
            String hashingPassword = passwordEncoder.hashPassword(LibraryNewUser.getUserpassword());
            // set on bean newUser
            LibraryNewUser.setUserpassword(hashingPassword);
            // write on bdd
            libraryUserManager.addNewUserOnBDD(LibraryNewUser);

            return "confirmationhtml/userWrittingOk";
        }
    }
}
