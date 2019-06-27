package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientbusiness.contract.PasswordEncoder;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUserBean;
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
     * @param newUser -> bean to validate
     * @param bindingResult -> list of error
     * @param model -> models
     * @return
     */
    @PostMapping(value = "/newUserPost")
    public String newUserPost(@Valid @ModelAttribute("newUser") LibraryUserBean newUser, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("newUser", newUser);
            logger.info("*********");
            logger.info("erreur lors du remplissage formulaire enregistrement nouvel utilisateur");
            logger.debug("debug");

            return "/newUser";
        } else {
            // hashing new password
            String hashingPassword = passwordEncoder.hashPassword(newUser.getUserpassword());
            // set on bean newUser
            newUser.setUserpassword(hashingPassword);
            //todo method for write on bdd

            return "confirmationhtml/userWrittingOk";
        }
    }
}
